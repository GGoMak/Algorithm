#include <iostream>
#include <queue>
#include <algorithm>

/*
 * 백준 12100번 : 2048(23%)
 * DFS
 */

using namespace std;
int N;
int map[21][21];
int res;

void move(int dir){

    queue<int> q;

    if(dir == 0){               // 동
        for(int i = 0; i < N; i++){
            for(int j = N - 1; j >= 0; j--){
                if(map[i][j] != 0) {        // 숫자 블럭들을 q에 넣어준다(단 오른쪽으로 이동하니까 오른쪽블럭부터 큐에 넣는다)
                    q.push(map[i][j]);
                    map[i][j] = 0;
                }
            }

            int idx = N - 1;                // 채워나갈 인덱스를 정해준다(오른쪽으로 이동하니까 오른쪽부터 채워나간다)

            while(!q.empty()){
                int cur = q.front();
                q.pop();

                if(map[i][idx] == 0){       // 현재 채워야할 공간에 블럭이 없으면 블럭을 넣어준다
                    map[i][idx] = cur;
                }
                else if(map[i][idx] == cur){    // 현재 채워진 공간의 블럭과 넣을려는 블럭이 같은 블럭이면 합쳐준다.
                    map[i][idx] *= 2;
                    idx--;
                }
                else{                           // 현재 채워진 공간의 블럭과 넣을려는 블럭이 다르면 다음칸에 블럭을 넣는다.
                    map[i][idx - 1] = cur;
                    idx--;
                }
            }
        }
    }
    else if(dir == 1){          // 서
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != 0){
                    q.push(map[i][j]);
                    map[i][j] = 0;
                }
            }

            int idx = 0;

            while(!q.empty()){
                int cur = q.front();
                q.pop();

                if(map[i][idx] == 0){
                    map[i][idx] = cur;
                }
                else if(map[i][idx] == cur){
                    map[i][idx] *= 2;
                    idx++;
                }
                else{
                    map[i][idx + 1] = cur;
                    idx++;
                }
            }
        }
    }
    else if(dir == 2){          // 남
        for(int j = 0; j < N; j++){
            for(int i = N - 1; i >= 0; i--){
                if(map[i][j] != 0){
                    q.push(map[i][j]);
                    map[i][j] = 0;
                }
            }

            int idx = N - 1;

            while(!q.empty()){
                int cur = q.front();
                q.pop();

                if(map[idx][j] == 0){
                    map[idx][j] = cur;
                }
                else if(map[idx][j] == cur){
                    map[idx][j] *= 2;
                    idx--;
                }
                else{
                    map[idx - 1][j] = cur;
                    idx--;
                }
            }
        }
    }
    else{                       // 북
        for(int j = 0; j < N; j++){
            for(int i = 0; i < N; i++){
                if(map[i][j] != 0){
                    q.push(map[i][j]);
                    map[i][j] = 0;
                }
            }

            int idx = 0;

            while(!q.empty()){
                int cur = q.front();
                q.pop();

                if(map[idx][j] == 0){
                    map[idx][j] = cur;
                }
                else if(map[idx][j] == cur){
                    map[idx][j] *= 2;
                    idx++;
                }
                else{
                    map[idx + 1][j] = cur;
                    idx++;
                }
            }
        }
    }
}

void dfs(int dep){

    if(dep == 5){       // dfs를 5번 초과 수행했으면 결과값 계산
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                res = max(res, map[i][j]);
            }
        }
        return;
    }

    int tmpMap[21][21];

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            tmpMap[i][j] = map[i][j];
        }
    }

    for(int i = 0; i < 4; i++){
        move(i);    // i방향으로 블럭을 이동 시키고
        dfs(dep + 1);   // dfs탐색

        for(int p = 0; p < N; p++){ // 블럭을 원위치 시킨다
            for(int q = 0; q < N; q++){
                map[p][q] = tmpMap[p][q];
            }
        }
    }
}


int main(void){

    cin >> N;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> map[i][j];
        }
    }

    dfs(0);

    cout << res;

    return 0;
}