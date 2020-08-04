#include <iostream>
#include <cstring>
#include <algorithm>

/*
 * 비타알고 2020년 3월 1주차 3번 : 놀이동산(난이도 4)
 * DP
 *
 * 메모이제이션 + 비트마스크
*/

using namespace std;

int N;
int arr[16][16];
int d[1 << 16][16];

int dp(int cur, int stat){

    if(stat == (1 << N) - 1){
        if(arr[cur][0]){        // 마지막 위치에서 출발 위치로 돌아갈 수 있는지 확인
            return arr[cur][0];
        }
        else{
            return 1e9;
        }
    }

    int &res = d[stat][cur];

    if(res != -1){
        return res;
    }

    res = 1e9;

    for(int i = 0; i < N; i++){
        if((stat & (1 << i)) == 0 && arr[cur][i] != 0){     // i번째 노드에 방문하지 않았고, cur에서 i번째 노드로 갈 수 있는 경우
            res = min(res, dp(i, stat | (1 << i)) + arr[cur][i]);
        }
    }
    return res;
}

int main(void){

    cin >> N;

    memset(d, -1, sizeof(d));
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> arr[i][j];
        }
    }

    cout << dp(0, 1);

    return 0;
}