#include <iostream>
#include <vector>
#include <queue>

/*
 * 비타알고 2020년 4월 2주차 3번 : 경유지(난이도 5)
 * LCA
 *
 * 이 문제에서는 노드들이 트리의 구조를 나타내고 있다는 점이 중요
 * A - C - (B)의 경로일 경우 lca(A, B) == lca(B, C), lca(A, C) == C
 * B - C - (A)의 경로일 경우 lca(A, B) == lca(A, C), lca(B, C) == C
 * A - C - (P) - B의 경로일 경우 lca(A, B) == lca(B, C), lca(A, C) == C
 * B - C - (P) - A의 경로일 경우 lca(A, B) == lca(A, C), lca(B, C) == C
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
            int idx = v[cur][i];

            if(d[idx] == 0){
                p[idx][0] = cur;
                d[idx] = d[cur] + 1;
                q.push(idx);
            }
        }
    }
}

void getParent(){
    for(int i = 1; (1 << i) < N; i++){
        for(int j = 1; j <= N; j++){
            if(p[j][i-1] != 0){
                p[j][i] = p[p[j][i-1]][i-1];
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
        if(d[a] - (1 << i) >= 0 && p[a][i] != p[b][i]){
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
        int a, b, c;
        cin >> a >> b >> c;

        int point = lca(a, b);

        if((point == lca(b, c) && c == lca(a, c)) || (point == lca(a, c) && c == lca(b, c))){
            cout << "1" << endl;
        }
        else{
            cout << "0" << endl;
        }
    }

    return 0;
}