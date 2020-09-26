#include <iostream>
#include <vector>

/*
 * 백준 15683번 : 감시(40%)
 * DFS
 */

using namespace std;
int N, M, K;
int map[8][8];
int check[8][8];
int result = 987654321;
vector<pair<int, int>> cctv;

int count(){

    int res = 0;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(map[i][j] == 0){
                res++;
            }
        }
    }

    return res;
}

void fill(int x, int y, int dir){
    int p = x;
    int q = y;
    int nn = map[x][y];

    if(dir == 0){
        while(map[p][q] != 6){
            if(q >= M){
                break;
            }
            if(map[p][q] == 0) {
                map[p][q] = '#';
                check[p][q] += nn;
            }
            else if(map[p][q] == '#'){
                check[p][q] += nn;
            }
            q++;
        }
    }
    else if(dir == 1){
        while(map[p][q] != 6){
            if(p >= N){
                break;
            }
            if(map[p][q] == 0) {
                map[p][q] = '#';
                check[p][q] += nn;
            }
            else if(map[p][q] == '#'){
                check[p][q] += nn;
            }
            p++;
        }
    }
    else if(dir == 2){
        while(map[p][q] != 6){
            if(q < 0){
                break;
            }
            if(map[p][q] == 0) {
                map[p][q] = '#';
                check[p][q] += nn;
            }
            else if(map[p][q] == '#'){
                check[p][q] += nn;
            }
            q--;
        }
    }
    else if(dir == 3){
        while(map[p][q] != 6){
            if(p < 0){
                break;
            }
            if(map[p][q] == 0) {
                map[p][q] = '#';
                check[p][q] += nn;
            }
            else if(map[p][q] == '#'){
                check[p][q] += nn;
            }
            p--;
        }
    }

    map[x][y] = nn;
}

void unfill(int x, int y, int dir){
    int p = x;
    int q = y;
    int nn = map[x][y];

    if(dir == 0){
        while(map[p][q] != 6){
            if(q >= M){
                break;
            }
            if(map[p][q] == '#' && check[p][q] - nn == 0) {
                map[p][q] = 0;
                check[p][q] -= nn;
            }
            else if(map[p][q] == '#'){
                check[p][q] -= nn;
            }
            q++;
        }
    }
    else if(dir == 1){
        while(map[p][q] != 6){
            if(p >= N){
                break;
            }
            if(map[p][q] == '#' && check[p][q] - nn == 0) {
                map[p][q] = 0;
                check[p][q] -= nn;
            }
            else if(map[p][q] == '#'){
                check[p][q] -= nn;
            }
            p++;
        }
    }
    else if(dir == 2){
        while(map[p][q] != 6){
            if(q < 0){
                break;
            }
            if(map[p][q] == '#' && check[p][q] - nn == 0) {
                map[p][q] = 0;
                check[p][q] -= nn;
            }
            else if(map[p][q] == '#'){
                check[p][q] -= nn;
            }
            q--;
        }
    }
    else if(dir == 3){
        while(map[p][q] != 6){
            if(p < 0){
                break;
            }
            if(map[p][q] == '#' && check[p][q] - nn == 0) {
                map[p][q] = 0;
                check[p][q] -= nn;
            }
            else if(map[p][q] == '#'){
                check[p][q] -= nn;
            }
            p--;
        }
    }

    map[x][y] = nn;
}

void dfs(int n){

    if(n == K){
        result = min(result, count());
        return;
    }

    pair<int, int> cctvPos = cctv[n];

    int dir = 0;

    if(map[cctvPos.first][cctvPos.second] == 1){
        for(int i = 0; i < 4; i++) {
            fill(cctvPos.first, cctvPos.second, i);
            dfs(n + 1);
            unfill(cctvPos.first, cctvPos.second, i);
        }
    }
    else if(map[cctvPos.first][cctvPos.second] == 2){
        for(int i = 0; i < 2; i++){
            fill(cctvPos.first, cctvPos.second, dir % 4);
            fill(cctvPos.first, cctvPos.second, (dir + 2) % 4);
            dfs(n + 1);
            unfill(cctvPos.first, cctvPos.second, dir % 4);
            unfill(cctvPos.first, cctvPos.second, (dir + 2) % 4);
            dir++;
        }
    }
    else if(map[cctvPos.first][cctvPos.second] == 3){
        for(int i = 0; i < 4; i++){
            fill(cctvPos.first, cctvPos.second, dir % 4);
            fill(cctvPos.first, cctvPos.second, (dir + 1) % 4);
            dfs(n + 1);
            unfill(cctvPos.first, cctvPos.second, dir % 4);
            unfill(cctvPos.first, cctvPos.second, (dir + 1) % 4);
            dir++;
        }
    }
    else if(map[cctvPos.first][cctvPos.second] == 4){
        for(int i = 0; i < 4; i++){
            fill(cctvPos.first, cctvPos.second, dir % 4);
            fill(cctvPos.first, cctvPos.second, (dir + 1) % 4);
            fill(cctvPos.first, cctvPos.second, (dir + 2) % 4);
            dfs(n + 1);
            unfill(cctvPos.first, cctvPos.second, dir % 4);
            unfill(cctvPos.first, cctvPos.second, (dir + 1) % 4);
            unfill(cctvPos.first, cctvPos.second, (dir + 2) % 4);
            dir++;
        }
    }
    else if(map[cctvPos.first][cctvPos.second] == 5){
        fill(cctvPos.first, cctvPos.second, 0);
        fill(cctvPos.first, cctvPos.second, 1);
        fill(cctvPos.first, cctvPos.second, 2);
        fill(cctvPos.first, cctvPos.second, 3);
        dfs(n + 1);
        unfill(cctvPos.first, cctvPos.second, 0);
        unfill(cctvPos.first, cctvPos.second, 1);
        unfill(cctvPos.first, cctvPos.second, 2);
        unfill(cctvPos.first, cctvPos.second, 3);
    }

}

int main(void){

    cin >> N >> M;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> map[i][j];

            if(1 <= map[i][j] && map[i][j] <= 5){
                cctv.push_back(make_pair(i, j));
                K++;
            }
        }
    }

    dfs(0);

    cout << result;

    return 0;
}
