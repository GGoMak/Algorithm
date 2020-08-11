#include <iostream>
#include <vector>
#include <queue>

/*
 * 비타알고 2020년 4월 2주차 1번 : LCA(난이도 3)
 * LCA(BFS)
 *
 * BFS를 통해 check배열에 깊이와 부모의 정보를 넣는다 (check.first : 깊이. check.second : 부모)
 * 깊이가 깊은 노드를 한단계씩 깊이를 올리면서 깊이가 낮은쪽 노드에 깊이를 맞춘다
 * 깊이가 같은데 노드가 같다면 답
 * 깊이가 같은데 노드가 다르다면 서로 같아질 때까지 깊이를 한단계씩 낮춘다
*/

using namespace std;
int N, A, B;
vector<int> v[100001];
pair<int, int> check[100001];

void bfs(){

    queue<int> q;

    q.push(1);
    check[1] = {1, -1};

    while(!q.empty()){
        int cur = q.front();
        q.pop();

        for(int i = 0; i < v[cur].size(); i++){
            int nx = v[cur][i];
            if(check[nx].first == 0){
                check[nx].first = check[cur].first + 1;
                check[nx].second = cur;
                q.push(nx);
            }
        }
    }
}

int main(void){

    cin >> N;

    for(int i = 0; i < N - 1; i++){
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    cin >> A >> B;

    bfs();

    while(check[A].first != check[B].first){
        if(check[A].first < check[B].first){    // B노드가 A노드 보다 깊다면 B노드를 부모노드로 올린다.
            B = check[B].second;
        }
        else if(check[A].first > check[B].first){   // A노드가 B노드 보다 깊다면 A노드를 부모노드로 올린다.
            A = check[A].second;
        }
    }

    while(A != B){  // 깊이가 같은데 노드가 다르면 같아질 때까지 부모노드로 올린다.
        A = check[A].second;
        B = check[B].second;
    }

    cout << A;

    return 0;
}