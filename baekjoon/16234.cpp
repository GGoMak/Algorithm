#include <iostream>
#include <queue>
#include <algorithm>

/*
 * 백준 16234번 : 인구 이동(36%)
 * BFS
 */

using namespace std;
int N, L, R, result;
int map[51][51];
int visit[51][51];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
vector<vector<pair<int, int>>> v;

bool move(){

    int check = 0;

    for(int i = 0; i < v.size(); i++){
        if(v[i].size() == 1){
            check++;
        }
    }

    if(v.size() == check){
        return false;
    }

    for(int i = 0; i < v.size(); i++){
        int count = 0;
        for(int j = 0; j < v[i].size(); j++){
            count += map[v[i][j].first][v[i][j].second];
        }
        count /= v[i].size();

        for(int j = 0; j < v[i].size(); j++){
            map[v[i][j].first][v[i][j].second] = count;
        }
    }

    return true;

}

void open(int x, int y){

    queue<pair<int, int>> q;
    q.push(make_pair(x, y));
    visit[x][y] = 1;

    vector<pair<int, int>> tv;

    while(!q.empty()){
        int nx = q.front().first;
        int ny = q.front().second;
        q.pop();

        tv.push_back(make_pair(nx, ny));

        for(int i = 0; i < 4; i++){
            int nnx = nx + dx[i];
            int nny = ny + dy[i];

            int num = abs(map[nnx][nny] - map[nx][ny]);

            if(0 <= nnx && nnx < N && 0 <= nny && nny < N && visit[nnx][nny] != 1 && (L <= num && num <= R)){
                q.push(make_pair(nnx, nny));
                visit[nnx][nny] = 1;
            }
        }
    }

    if(tv.size() != 0){
        v.push_back(tv);
    }
}

int main(void){


    cin >> N >> L >> R;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> map[i][j];
        }
    }

    while(1) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == 0) {
                    open(i, j);
                }
            }
        }

        if (!move()) {
            break;
        }
        v.erase(v.begin(), v.end());
        result++;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                visit[i][j] = 0;
            }
        }
    }

    cout << result;

    return 0;
}
