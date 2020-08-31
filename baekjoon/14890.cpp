#include <iostream>
#include <vector>

/*
 * 백준 14890번 : 경사로(53%)
 * 구현
 */

using namespace std;
int N, L;
int map[101][101];

bool checkRow(int row){

    int visit[101] = {0};

    for(int i = 0; i < N - 1; i++){
        if(abs(map[row][i] - map[row][i + 1]) > 1){
            return false;
        }

        else if(map[row][i] - map[row][i + 1] == 1){
            if(visit[i + 1] == 1){
                return false;
            }

            visit[i + 1] = 1;

            for(int j = 1; j < L; j++){
                if(i + j >= N){
                    return false;
                }
                else if(map[row][i] - map[row][i + j + 1] != 1){
                    return false;
                }
                else if(visit[i + j + 1]){
                    return false;
                }
                visit[i + j + 1] = 1;
            }
        }

        else if(map[row][i + 1] - map[row][i] == 1){
            if(visit[i] == 1){
                return false;
            }

            visit[i] = 1;
            for(int j = 1; j < L; j++){
                if(i - j < 0){
                    return false;
                }
                else if(map[row][i + 1] - map[row][i - j] != 1){
                    return false;
                }
                else if(visit[i - j]){
                    return false;
                }
                visit[i - j] = 1;
            }
        }
    }

    return true;
}

bool checkCol(int col){

    int visit[101] = {0};

    for(int i = 0; i < N - 1; i++){
        if(abs(map[i][col] - map[i + 1][col]) > 1){
            return false;
        }

        else if(map[i][col] - map[i + 1][col] == 1){
            if(visit[i + 1] == 1){
                return false;
            }

            visit[i + 1] = 1;

            for(int j = 1; j < L; j++){
                if(i + j >= N){
                    return false;
                }
                else if(map[i][col] - map[i + j + 1][col] != 1){
                    return false;
                }
                else if(visit[i + j + 1]){
                    return false;
                }
                visit[i + j + 1] = 1;
            }
        }

        else if(map[i + 1][col] - map[i][col] == 1){
            if(visit[i] == 1){
                return false;
            }

            visit[i] = 1;
            for(int j = 1; j < L; j++){
                if(i - j < 0){
                    return false;
                }
                else if(map[i + 1][col] - map[i - j][col] != 1){
                    return false;
                }
                else if(visit[i - j]){
                    return false;
                }
                visit[i - j] = 1;
            }
        }
    }

    return true;
}


int main(void){

    cin >> N >> L;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> map[i][j];
        }
    }

    int res = 0;

    for(int i = 0; i < N; i++){
        if(checkRow(i)){
            res++;
        }
        if(checkCol(i)){
            res++;
        }
    }

    cout << res;

    return 0;
}