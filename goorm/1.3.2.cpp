#include <iostream>
#include <vector>
#include <queue>

/*
 * 비타알고 2020년 1월 3주차 2번 : 졸업(난이도 3)
 * BFS
 *
 * 간선의 방향을 반대로 뒤집어서 계산하는 것이 핵심(최종 도착지점을 시작점으로 잡아서 거꾸로 계산)
 */

using namespace std;

int N, M, C;
int map[100010];    // 노드 방문여부 표시
vector<int> arr[100010];    // 그래프
queue<int> q;

int main(){

    cin >> N >> M;

    for(int i = 0; i < M; i++){
        int a, b;
        cin >> a >> b;
        arr[b].push_back(a);    // 간선의 방향을 바꿈
    }

    cin >> C;

    int result = 0;
    q.push(C);  // 시작점 큐에 삽입
    map[C] = 1; // 방문 표시

    while(!q.empty()){
        int cur = q.front();    // 큐에서 값을 가져오고
        q.pop();
        result++;               // 방문했으니 카운트 1 증가

        for(int i = 0; i < arr[cur].size(); i++){   // 큐에서 가져온 값(노드)에서 갈수 있는 노드들 중 방문하지 않은 노드들을 큐에 삽입하고 방문 표시
            if(!map[arr[cur][i]]){
                map[arr[cur][i]] = 1;
                q.push(arr[cur][i]);
            }
        }
    }

    cout << result;

    return 0;
}