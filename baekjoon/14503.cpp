#include <iostream>

/*
 * 백준 14503번 : 로봇 청소기(51%)
 * 구현
 */

using namespace std;
int N, M;
int R, C, D;
int map[51][51];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int res;

void clean(int x, int y, int dir){

    if(map[x][y] == 1){     // 도착한 곳이 벽이면 종료
        return;
    }

    if(map[x][y] == 0) {    // 도착한 곳이 빈칸이면 청소
        map[x][y] = 2;
        res++;
    }

    for(int i = 0; i < 4; i++){ // 네 방향 검사
        int ndir = dir - 1 < 0 ? 3 : dir - 1;
        int nx = x + dx[ndir];
        int ny = y + dy[ndir];

        if(map[nx][ny] == 0){   // 갈 곳이 빈칸이면 이동
            clean(nx, ny, ndir);
            return;
        }
        else{                   // 빈칸이 아니면 방향만 변경
            dir = ndir;
        }
    }

    // 네 방향 모두 청소되어 있거나 벽일 경우 후진
    int nx = x - dx[dir];
    int ny = y - dy[dir];
    clean(nx, ny, dir);

}

int main(void){

    cin >> N >> M;
    cin >> R >> C >> D;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> map[i][j];
        }
    }

    clean(R, C, D);

    cout << res;

    return 0;
}
