#include <iostream>

/*
 * 비타알고 2020년 1월 3주차 3번 : 닭 농장(난이도 3)
 * 분할정복, 피보나치 수열
 *
 * 분할정복과 행렬을 이용한 피보나치 수열 풀이
 */

using namespace std;
long long N;

void mulMatrix(long long a[2][2], long long b[2][2]){

    long long tmpMatrix[2][2] = {0};

    for(int i = 0; i < 2; i++){ // 행렬 곱셈
        for(int j = 0; j < 2; j++){
            for(int k = 0; k < 2; k++){
                tmpMatrix[i][j] += a[i][k] * b[k][j];
                tmpMatrix[i][j] %= 1000000007;
            }
        }
    }

    for(int i = 0; i < 2; i++){ // 곱셈 결과 저장
        for(int j = 0; j < 2; j++){
            a[i][j] = tmpMatrix[i][j];
        }
    }

}

long long fibo(long long N){

    long long aMatrix[2][2] = {{1, 1}, {1, 0}};
    long long bMatrix[2][2] = {{1, 1}, {1, 0}};

    while(N) {

        if (N % 2) {
            mulMatrix(aMatrix, bMatrix);
        }

        mulMatrix(bMatrix, bMatrix);

        N /= 2;
    }

    return aMatrix[1][1];

}

int main(){

    cin >> N;

    cout << fibo(N);

    return 0;
}