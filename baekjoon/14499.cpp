#include <iostream>
#include <queue>
#include <algorithm>

/*
 * 백준 14499번 : 주사위 굴리기(41%)
 * 구현
 */

using namespace std;
int N, M, K;
pair<int, int> location;
int map[21][21];
int dice[7];
vector<int> order;

int print(int dir){

    if(dir == 1){
        location.second += 1;

        if(location.second >= M){
            location.second -= 1;
            return -1;
        }

        int tmp = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = dice[3];
        dice[3] = tmp;

        if(map[location.first][location.second] != 0){
            dice[6] = map[location.first][location.second];
            map[location.first][location.second] = 0;
        }
        else{
            map[location.first][location.second] = dice[6];
        }
    }
    else if(dir == 2){
        location.second -= 1;

        if(location.second < 0){
            location.second += 1;
            return -1;
        }

        int tmp = dice[1];
        dice[1] = dice[3];
        dice[3] = dice[6];
        dice[6] = dice[4];
        dice[4] = tmp;

        if(map[location.first][location.second] != 0){
            dice[6] = map[location.first][location.second];
            map[location.first][location.second] = 0;
        }
        else{
            map[location.first][location.second] = dice[6];
        }
    }
    else if(dir == 3){
        location.first -= 1;

        if(location.first < 0){
            location.first += 1;
            return -1;
        }

        int tmp = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[6];
        dice[6] = dice[2];
        dice[2] = tmp;

        if(map[location.first][location.second] != 0){
            dice[6] = map[location.first][location.second];
            map[location.first][location.second] = 0;
        }
        else{
            map[location.first][location.second] = dice[6];
        }
    }

    else{
        location.first += 1;

        if(location.first >= N){
            location.first -= 1;
            return -1;
        }

        int tmp = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[6];
        dice[6] = dice[5];
        dice[5] = tmp;

        if(map[location.first][location.second] != 0){
            dice[6] = map[location.first][location.second];
            map[location.first][location.second] = 0;
        }
        else{
            map[location.first][location.second] = dice[6];
        }
    }

    return dice[1];
}

int main(void){

    cin >> N >> M >> location.first >> location.second >> K;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> map[i][j];
        }
    }

    for(int i = 0; i < K; i++){
        int p;
        cin >> p;
        order.push_back(p);
    }

    for(int i = 0; i < K; i++){
        int num = print(order[i]);
        if(num != -1){
            cout << num << endl;
        }
    }

    return 0;
}