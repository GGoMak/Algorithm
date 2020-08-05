#include <iostream>
#include <queue>
/*
 * 비타알고 2020년 3월 3주차 2번 : 제습제(난이도 3)
 * BFS
*/

using namespace std;

int N;
int map[1010][1010];
int check[1010][1010];
int cnt;
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

typedef struct Node{
    int x;
    int y;
}Node;

int start(){

    queue<Node> que;
    int res = 0;

    while(cnt) {
        res++;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int p = 0; p < 4; p++) {
                    int nx = i + dx[p];
                    int ny = j + dy[p];

                    if (map[i][j] == 0 && map[nx][ny] == 1 && check[nx][ny] == 0) {
                        check[nx][ny] = 1;
                        que.push({nx, ny});

                    }
                }
            }
        }

        while (!que.empty()) {
            int nx = que.front().x;
            int ny = que.front().y;
            que.pop();

            if(map[nx][ny] != 0){
                cnt--;
            }

            map[nx][ny] = 0;
            check[nx][ny] = 0;
        }
    }

    return res;
}

int main(){

    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> map[i][j];

            if(map[i][j] == 1){
                cnt++;
            }
        }
    }

    if(cnt == N * N){   // 모든 공간이 제습제일 경우 bfs가 진행되지 않음
        cout << -1;
        return 0;
    }

    cout << start();    // bfs 진행

    return 0;
}