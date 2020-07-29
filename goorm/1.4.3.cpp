#include <iostream>
#include <vector>
#include <queue>
#include <climits>
/*
 * 비타알고 2020년 1월 4주차 3번 : 스키장(난이도 4)
 * BFS + 이분탐색
 */

using namespace std;

typedef struct Node{
    int to;
    int difficulty;
}Node;

int N, M, from, to;
vector<Node> v[10001];

bool bfs(int mid){

    int check[10001] = {0}; // 방문여부 체크
    check[from] = 1;        // from 부터 시작하기 때문에 방문 표시
    queue<Node> q;

    q.push({from, 0});

    while(!q.empty()){
        int q_to = q.front().to;
        int q_diff = q.front().difficulty;
        q.pop();

        if(q_to == to && q_diff <= mid){    // 도착지이고 이분탐색중인 난이도보다 낮으면 true 리턴
            return true;
        }

        for(int i = 0; i < v[q_to].size(); i++){    // 큐에 넣을 노드 검색
            int qq_to = v[q_to][i].to;
            int qq_diff = v[q_to][i].difficulty;

            if(check[qq_to] == 0 && qq_diff <= mid){    // 방문하지 않았고 이분탐색중인 난이도보다 낮으면 큐에 삽입 하고 방문 표시
                q.push({qq_to, qq_diff});
                check[qq_to] = 1;
            }
        }
    }

    return false;
}

int main(void){

    cin >> N >> M;
    int maxi = 0;
    int mini = INT_MAX;

    for(int i = 0; i < M; i++){
        int a, b, c;
        cin >> a >> b >> c;
        v[a].push_back({b, c});
        maxi = max(maxi, c);
        mini = min(mini, c);
    }

    cin >> from >> to;

    int result;

    while(mini <= maxi){    // 이분 탐색
        int mid = (mini + maxi) / 2;

        if(bfs(mid)){   // mid 난이도보다 낮거나 같은 난이도로 도착지점에 도착할 수 있는 슬로프가 있는지 검사
            maxi = mid - 1;
            result = mid;
        }
        else{
            mini = mid + 1;
        }
    }

    cout << result;

    return 0;
}