#include <iostream>
#include <queue>
#include <climits>

/*
 * 백준 17136번 : 색종이 붙이기(31%)
 * DFS + 구
 */

using namespace std;
int map[11][11];
vector<int> paper(6);
int res = INT_MAX;

bool check(int x, int y, int k){

    for(int i = x; i < x + k; i++){
        for(int j = y; j < y + k; j++){
            if(map[i][j] == 0){
                return false;
            }
        }
    }

    return true;
}

void post(int x, int y, int k){

    for(int i = x; i < x + k; i++){
        for(int j = y; j < y + k; j++){
            map[i][j] = 0;
        }
    }
}

void del(int x, int y, int k){

    for(int i = x; i < x + k; i++){
        for(int j = y; j < y + k; j++){
            map[i][j] = 1;
        }
    }
}

void dfs(int x, int y, int cnt){

    while(map[x][y] == 0){  // 색종이를 붙일 곳을 검색
        if(x++ >= 9){
            if(y++ >= 9){
                res = min(res, cnt);
                return;
            }
            x = 0;
        }
    }

    if(cnt > res){
        return;
    }

    for(int k = 5; k > 0; k--){ // 5 ~ 1 크기의 색종이를 붙인다
        if(check(x, y, k) && paper[k] < 5) {
            post(x, y, k);
            paper[k]++;
            dfs(x, y, cnt + 1);
            del(x, y, k);
            paper[k]--;
        }
    }
}

int main(void){
    vector<int> num(5);

    for(int i = 0; i < 10; i++){
        for(int j = 0; j < 10; j++){
            cin >> map[i][j];
        }
    }

    dfs(0, 0, 0);

    if(res == INT_MAX){
        cout << -1;
    }
    else{
        cout << res;
    }

    return 0;
}
