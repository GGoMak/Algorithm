#include <iostream>

/*
 * 백준 14891번 : 톱니바퀴(51%)
 * 구현
 */

using namespace std;
char A[4][8];
int visit[4];
int K;

void clock(int n);
void unclock(int n);

void clock(int n){
    visit[n] = 1;

    if(n - 1 >= 0 && A[n][6] != A[n - 1][2] && visit[n - 1] == 0){
        unclock(n - 1);
    }

    if(n + 1 <= 4 && A[n][2] != A[n + 1][6] && visit[n + 1] == 0){
        unclock(n + 1);
    }

    char tmp = A[n][7];

    for(int i = 7; i > 0; i--){
        A[n][i] = A[n][i - 1];
    }
    A[n][0] = tmp;
}

void unclock(int n){
    visit[n] = 1;

    if(n - 1 >= 0 && A[n][6] != A[n - 1][2] && visit[n - 1] == 0){
        clock(n - 1);
    }

    if(n + 1 <= 4 && A[n][2] != A[n + 1][6] && visit[n + 1] == 0){
        clock(n + 1);
    }

    char tmp = A[n][0];

    for(int i = 0; i < 7; i++){
        A[n][i] = A[n][i + 1];
    }

    A[n][7] = tmp;
}

int main(void){

    for(int i = 0; i < 4; i++){
        cin >> A[i];
    }

    cin >> K;

    for(int i = 0; i < K; i++){

        for(int j = 0; j < 4; j++){
            visit[j] = 0;
        }

        int a, b;
        cin >> a >> b;

        if(b == 1){
            clock(a - 1);
        }
        else{
            unclock(a - 1);
        }
    }

    int res = 0, cnt = 1;

    for(int i = 0; i < 4; i++){
        res += (A[i][0] - '0') * cnt;
        cnt *= 2;
    }

    cout << res;

    return 0;
}
