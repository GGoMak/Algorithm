#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

/*
 * 백준 14502번 : 연구소(54%)
 * DFS + BFS
 */

using namespace std;
int N, M;
int map[9][9];
vector<pair<int, int>> virus;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int count(){        // BFS(바이러스 퍼뜨리기)

    queue<pair<int, int>> q;
    int tmp[9][9];
    int cnt = 0;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            tmp[i][j] = map[i][j];
        }
    }

    for(int i = 0; i < virus.size(); i++){
        q.push(make_pair(virus[i].first, virus[i].second));
    }

    while(!q.empty()){
        int nx = q.front().first;
        int ny = q.front().second;
        q.pop();

        for(int i = 0; i < 4; i++){
            int nnx = nx + dx[i];
            int nny = ny + dy[i];

            if(nnx >= 0 && nnx < N && nny >= 0 && nny < M && map[nnx][nny] == 0){
                q.push(make_pair(nnx, nny));
                map[nnx][nny] = 2;
            }
        }
    }

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(map[i][j] == 0){
                cnt++;
            }
            map[i][j] = tmp[i][j];
        }
    }

    return cnt;

}

int dfs(int n){     // DFS(벽 세우기)

    int res = 0;

    if(n == 3){
        return count();
    }

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(map[i][j] == 0) {
                map[i][j] = 1;
                res = max(res, dfs(n + 1));
                map[i][j] = 0;
            }

        }
    }

    return res;
}

int main(void){

    cin >> N >> M;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> map[i][j];

            if(map[i][j] == 2){
                virus.push_back(make_pair(i, j));
            }
        }
    }

    cout << dfs(0);

    return 0;
}
