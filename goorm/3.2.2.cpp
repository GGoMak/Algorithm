#include <iostream>

/*
 * 비타알고 2020년 3월 2주차 2번 : 하모니(난이도 3)
 * DP
 *
 * dp[i][j] =  i개의 원소로 낼 수 있는 소리중 끝자리가 j인 수
*/

using namespace std;

int N;
long long dp[101][10];

int main(){

    cin >> N;

    for(int i = 0; i < 10; i++){
        dp[0][i] = 1;
    }

    for(int i = 1; i < N; i++){
        for(int j = 0; j < 10; j++){
            if(j == 0){         // 끝자리가 0일 때는 1하고만 화음이 됨
                dp[i][j] = dp[i-1][1];
            }
            else if(j == 9){    // 끝자리가 9일 때는 8하고만 화음이 됨
                dp[i][j] = dp[i-1][8];
            }
            else{               // 끝자리가 j일 때는 j-1과 j+1이 화음이 됨
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }
    }

    long long result = 0;

    for(int i = 0; i < 10; i++){
        result = (result + dp[N-1][i]) % 1000000000;
    }

    cout << result;

    return 0;
}