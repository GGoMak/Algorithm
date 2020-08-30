#include <iostream>
#include <algorithm>

/*
 * 백준 14500번 : 테트로미노(34%)
 * DFS + 계산
 *
 * 4개의 테트로미노 모형은 DFS로 해결이 가능하지만 'ㅗ'모형은 따로 계산해주어야 한다.
 */

using namespace std;

int N, M;
int map[501][501];
int visit[501][501];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int tro(int x, int y){
    int sum = 0;

    if(x >= 1 && y >= 1 && y < M - 1){      // ㅗ
        sum = max(sum, map[x][y - 1] + map[x][y] + map[x - 1][y] + map[x][y + 1]);
    }
    if(x >= 1 && x < N - 1 && y < M - 1){   // ㅏ
        sum = max(sum, map[x - 1][y] + map[x][y] + map[x][y + 1] + map[x + 1][y]);
    }
    if(x < N - 1 && y >= 1 && y < M - 1){   // ㅜ
        sum = max(sum, map[x][y - 1] + map[x][y] + map[x][y + 1] + map[x + 1][y]);
    }
    if(x >= 1 && x < N - 1 && y >= 1){      // ㅓ
        sum = max(sum, map[x - 1][y] + map[x][y] + map[x + 1][y] + map[x][y - 1]);
    }

    return sum;
}

int dfs(int x, int y, int dep){

    if(dep == 4){
        return map[x][y];
    }

    int sum = 0;

    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx >= 0 && nx < N && ny >= 0 && ny < M && visit[nx][ny] == 0){
            visit[nx][ny] = 1;
            sum = max(sum, map[x][y] + dfs(nx, ny, dep + 1));
            visit[nx][ny] = 0;
        }
    }

    return sum;
}

int main(void){

    cin >> N >> M;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> map[i][j];
        }
    }

    int res = 0;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            visit[i][j] = 1;
            res = max(res, dfs(i, j, 1));
            res = max(res, tro(i, j));
            visit[i][j] = 0;
        }
    }

    cout << res;

    return 0;
}