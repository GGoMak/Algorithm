#include <iostream>

/*
 * 비타알고 2020년 3월 3주차 3번 : 분해결합(난이도 5)
 * DP
*/

using namespace std;
long long N, M;
long long d[101][101];
long long mod = 1e9 + 7;

void matMul(long long a[101][101], long long b[101][101]){  // a와 b의 행렬곱을 a에 저장

    long long mat[101][101];

    for(int i = 0; i < M; i++){
        for(int j = 0; j < M; j++){
            mat[i][j] = 0;
            for(int k = 0; k < M; k++){
                mat[i][j] += a[i][k] * b[k][j];
                mat[i][j] %= mod;
            }
        }
    }

    for(int i = 0; i < M; i++){
        for(int j = 0; j < M; j++){
            a[i][j] = mat[i][j];
        }
    }
}

void matPow(long long n, long long res[101][101]){

    long long ans[101][101];
    long long b[101][101];

    for(int i = 0; i < M; i++){
        for(int j = 0; j < M; j++){
            ans[i][j] = d[i][j];
            b[i][j] = d[i][j];
        }
    }

    while(n){       // 거듭제곱 분할정복
        if(n % 2){
            matMul(ans, b);
            n--;
        }
        else{
            matMul(b, b);
            n = n / 2;
        }
    }

    for(int i = 0; i < M; i++){
        for(int j = 0; j < M; j++){
            res[i][j] = ans[i][j];
        }
    }
}

int main(void){

    cin >> N >> M;

    d[0][0] = 1;
    d[0][M - 1] = 1;
    for(int i = 1; i < M; i++){
        d[i][i - 1] = 1;
    }
    if(N < M){
        cout << 1;
    }
    else {
        long long res[101][101];
        matPow(N - M, res);

        long long result = 0;
        for (int i = 0; i < M; i++) {
            result += res[0][i];
            result %= mod;
        }

        cout << result;
    }

    return 0;
}