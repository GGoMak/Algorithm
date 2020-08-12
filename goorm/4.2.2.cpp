#include <iostream>
#include <vector>
#include <queue>

/*
 * 비타알고 2020년 4월 2주차 2번 : LCA2(난이도 4)
 * LCA(BFS + DP)
*/

using namespace std;
int N, M;
vector<int> v[100001];
int p[100001][20];
int d[100001];

void bfs(){
    queue<int> q;

    q.push(1);
    d[1] = 1;

    while(!q.empty()){
        int cur = q.front();
        q.pop();

        for(int i = 0; i < v[cur].size(); i++){
            int nx = v[cur][i];

            if(d[nx] == 0){
                p[nx][0] = cur;
                d[nx] = d[cur] + 1;
                q.push(nx);
            }
        }
    }
}

void getParent(){
    for(int i = 1; (1 << i) < N; i++){
        for(int j = 1; j <= N; j++){
            if(p[j][i-1] != 0){
                p[j][i] = p[p[j][i - 1]][i - 1];
            }
        }
    }
}

int lca(int a, int b){

    if(d[a] < d[b]){
        swap(a, b);
    }

    if(d[a] != d[b]){
        for(int i = 20; i >= 0; i--){
            if(d[a] - (1 << i) >= d[b]){
                a = p[a][i];
            }
        }
    }

    if(a == b){
        return a;
    }

    for(int i = 20; i >= 0; i--){
        if(d[a] - (1 << i) >= 0 && (p[a][i] != p[b][i])){
            a = p[a][i];
            b = p[b][i];
        }
    }

    return p[a][0];
}

int main(void){

    cin >> N;

    for(int i = 0; i < N - 1; i++){
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    bfs();
    getParent();

    cin >> M;

    for(int i = 0; i < M; i++){
        int a, b;
        cin >> a >> b;
        cout << lca(a, b) << endl;
    }

    return 0;
}