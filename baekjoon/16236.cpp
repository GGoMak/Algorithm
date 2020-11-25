#include <iostream>
#include <queue>

/*
 * 백준 16236번 : 아기 상어(38%)
 * BFS
 */

using namespace std;
int N;
int map[21][21];
int sharkX, sharkY, sharkSize, sharkEat;
int result;
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};

typedef struct Node{
    int x;
    int y;
    int cnt;
}Node;

int bfs(){

    int visit[21][21] = {0};
    int minX = 987654321, minY = 987654321, minDist = 987654321;

    queue<Node> q;
    q.push({sharkX, sharkY, 0});
    visit[sharkX][sharkY] = 1;

    while(!q.empty()){
        int nx = q.front().x;
        int ny = q.front().y;
        int ncnt = q.front().cnt;
        q.pop();

        if(0 < map[nx][ny] && map[nx][ny] < sharkSize){
            if(ncnt < minDist){
                minDist = ncnt;
                minX = nx;
                minY = ny;
            }
            else if(ncnt == minDist){
                if(nx < minX){
                    minX = nx;
                    minY = ny;
                }
                else if(minX == nx){
                    if(ny < minY){
                        minX = nx;
                        minY = ny;
                    }
                }
            }
            continue;
        }

        for(int i = 0; i < 4; i++){
            int nnx = nx + dx[i];
            int nny = ny + dy[i];

            if(nnx < 0 || nnx >= N || nny < 0 || nny >= N){
                continue;
            }
            if(visit[nnx][nny] == 1 || map[nnx][nny] > sharkSize){
                continue;
            }

            q.push({nnx, nny, ncnt + 1});
            visit[nnx][nny] = 1;
        }
    }

    sharkX = minX;
    sharkY = minY;

    return minDist;
}

int main(void){

    cin >> N;

    sharkSize = 2, sharkEat = 0;

    for(int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int num;
            cin >> num;
            map[i][j] = num;

            if(num == 9){
                sharkX = i;
                sharkY = j;
                map[i][j] = 0;
            }
        }
    }

    while(true){
        int dir = bfs();

        if(dir == 987654321){
            break;
        }

        map[sharkX][sharkY] = 0;

        result += dir;
        sharkEat++;

        if(sharkEat == sharkSize){
            sharkSize++;
            sharkEat = 0;
        }
    }

    cout << result;

    return 0;
}
