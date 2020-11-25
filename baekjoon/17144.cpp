#include <iostream>
#include <queue>
#include <algorithm>

/*
 * 백준 17144번 : 미세먼지 안녕!(53%)
 * 구현
 */

using namespace std;

int R, C, T;
int map[52][52];
int tmpMap[52][52];
int visit[52][52];
int airCleanerTop, airCleanerBottom;
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

void spread(int x, int y){

    int cnt = 0;

    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx < 0 || nx >= R || ny < 0 || ny >= C){
            continue;
        }

        if(ny == 0 && (nx == airCleanerTop || nx == airCleanerBottom)){
            continue;
        }

        tmpMap[nx][ny] += map[x][y] / 5;
        cnt++;
    }

    tmpMap[x][y] -= ((map[x][y] / 5) * cnt);
}

void wind(){

    int nx = airCleanerTop - 1, ny = 0;

    while(nx > 0){
        map[nx][ny] = map[nx - 1][ny];
        nx--;
    }

    while(ny < C - 1){
        map[nx][ny] = map[nx][ny + 1];
        ny++;
    }

    while(nx < airCleanerTop){
        map[nx][ny] = map[nx + 1][ny];
        nx++;
    }

    while(ny > 1){
        map[nx][ny] = map[nx][ny - 1];
        ny--;
    }

    map[nx][ny] = 0;

    nx = airCleanerBottom + 1, ny = 0;

    while(nx < R - 1){
        map[nx][ny] = map[nx + 1][ny];
        nx++;
    }

    while(ny < C - 1){
        map[nx][ny] = map[nx][ny + 1];
        ny++;
    }

    while(nx > airCleanerBottom){
        map[nx][ny] = map[nx - 1][ny];
        nx--;
    }

    while(ny > 1){
        map[nx][ny] = map[nx][ny - 1];
        ny--;
    }

    map[nx][ny] = 0;
}

int main(void){

    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> R >> C >> T;

    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            cin >> map[i][j];

            if(map[i][j] == -1 && airCleanerTop == 0){
                airCleanerTop = i;
                airCleanerBottom = i + 1;
            }
        }
    }

    for(int k = 0; k < T; k++) {

        for(int p = 0; p < R; p++){
            for(int q = 0; q < C; q++){
                tmpMap[p][q] = 0;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0 && map[i][j] != -1) {
                    spread(i, j);
                }
            }
        }

        for(int p = 0; p < R; p++){
            for(int q = 0; q < C; q++){
                map[p][q] += tmpMap[p][q];
            }
        }

        wind();
    }

    int result = 0;

    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            if(map[i][j] != 0 && map[i][j] != -1){
                result += map[i][j];
            }
        }
    }

    cout << result;

    return 0;
}