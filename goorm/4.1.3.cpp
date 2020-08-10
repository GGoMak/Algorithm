#include <iostream>
#include <vector>
#include <queue>

/*
 * 비타알고 2020년 4월 1주차 3번 : 전용망(난이도 3)
 * 최소신장트리, Prim 알고리즘
 *
 * 1. 노드 하나를 정하고 최소 신장 트리 그룹에 넣는다(check배열)
 * 2. 최소 신장 트리 그룹과 아닌 그룹을 잇는 간선중 가중치가 가장 작은 노드를 최소 신장 트리 그룹에 넣는다
*/

using namespace std;

int N, M;
vector<pair<int, int>> v[10001];
int check[10001];

typedef struct Node{
    int end;    // 도착지
    int weight; // 가중치
}Node;

bool operator < (Node n1, Node n2){ // priority_queue 연산
    return n1.weight > n2.weight;
}

int prim(){

    int result = 0;
    priority_queue<Node> q;

    check[1] = 1;   // 1번 노드부터 시작하고, 최소 신장 트리 그룹에 넣는다.

    for(int i = 0; i < v[1].size(); i++) {  // 1번 노드와 연결된 모든 노드들을 우선순위 큐에 넣는다.
        q.push({v[1][i].first, v[1][i].second});
    }

    while(!q.empty()){  // 우선순위 큐이기 때문에 큐에 들어간 노드들 중 가중치가 가장 작은 노드가 먼저 나오게 된다.
        int end = q.top().end;
        int weight = q.top().weight;
        q.pop();

        if(check[end] == 1){    // 이미 최소신장트리에 포함된 노드이면 건너뛴다.
            continue;
        }

        check[end] = 1;         // 최소신장트리 그룹에 넣는다
        result += weight;

        for(int i = 0; i < v[end].size(); i++){
            if(check[v[end][i].first] == 0){    // 최소신장트리 그룹에 포함되지 않는 노드들을 큐에 넣는다.
                q.push({v[end][i].first, v[end][i].second});
            }
        }
    }

    return result;
}

int main(void){

    cin >> N >> M;

    for(int i = 0; i < M; i++){
        int a, b, c;
        cin >> a >> b >> c;
        v[a].push_back({b, c});
        v[b].push_back({a, c});
    }

    cout << prim();

    return 0;
}