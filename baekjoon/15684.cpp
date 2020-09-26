#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

/*
 * 백준 15684번 : 사다리 조작(20%)
 * DFS
 */

using namespace std;
int N, M, H;
int result = 10;
int map[33][13][13];

bool checkMap(){

    for(int k = 1; k <= N; k++) {
        int line = k;

        for (int i = 1; i <= H; i++) {
            if (line + 1 <= N && map[i][line][line + 1] == 1) {
                line = line + 1;
            }
            else if (line - 1 > 0 && map[i][line][line - 1] == 1) {
                line = line - 1;
            }
        }

        if (line != k) {
            return false;
        }
    }

    return true;
}

void find(int x, int y, int cnt){

    if(checkMap()){
        result = min(result, cnt);
        return;
    }

    if(cnt == 3){   // cnt가 3일때 가지치기(3이 넘어가는 경우는 계산할 필요가 없음)
        return;
    }

    for(int i = x; i <= H; i++){
        for(int j = y; j < N; j++){
            if(map[i][j][j - 1] == 0 && map[i][j][j + 1] == 0 && map[i][j + 1][j + 2] == 0){
                map[i][j][j + 1] = 1;
                map[i][j + 1][j] = 1;
                find(i, j + 2, cnt + 1);
                map[i][j][j + 1] = 0;
                map[i][j + 1][j] = 0;
            }
        }
        y = 1;
    }
}

int main(void){

    cin >> N >> M >> H;

    for(int i = 0; i < M; i++){
        int a, b;
        cin >> a >> b;
        map[a][b][b + 1] = 1;
        map[a][b + 1][b] = 1;
    }

    find(1, 1, 0);

    if(result > 3){
        cout << -1;
    }
    else{
        cout << result;
    }

    return 0;
}
