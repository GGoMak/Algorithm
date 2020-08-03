#include <iostream>
#include <vector>
#include <queue>

/*
 * 비타알고 2020년 3월 1주차 1번 : 백신(난이도 3)
 * bfs
*/

using namespace std;
int N, M;
vector<int> v[200001];
int visit[200001];
int maxi, patient;

void bfs(int n){

    if(visit[n] == 1){
        return;
    }
    visit[n] = 1;

    queue<int> q;
    q.push(n);
    int count = 0;

    while(!q.empty()){
        int cur = q.front();
        q.pop();
        count++;

        for(int i = 0; i < v[cur].size(); i++){
            int index = v[cur][i];
            if(visit[index] == 0){
                visit[index] = 1;
                q.push(index);
            }
        }
    }

    if(maxi < count) {
        maxi = count;
        patient = n;
    }
}

int main(void){

    cin >> N >> M;

    for(int i = 1; i <= M; i++){
        int p, q;
        cin >> p >> q;
        v[p].push_back(q);
        v[q].push_back(p);
    }

    for(int i = 1; i <= N; i++){
        bfs(i);
    }

    cout << patient << " " << maxi;
    return 0;
}