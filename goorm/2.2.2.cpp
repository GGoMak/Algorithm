#include <iostream>
#include <algorithm>
/*
 * 비타알고 2020년 2월 2주차 2번 : 스노우보드 대회(난이도 3)
 * DP
 *
 * dp[i][j] = (i, j)까지의 최대값
 * 1. j == 0인 경우는 오른쪽 위에서만 내려올수 있으므로 dp[i][j] = dp[i-1][j] + val[i][j];
 * 2. i == j인 경우는 왼쪽 위에서만 내려올수 있으므로 dp[i][j] = dp[i-1][j-1] + val[i][j];
 * 3. 그 외의 경우는 양쪽 다 내려올 수 있으므로 양쪽 중 더 큰 값에 val[i][j]를 더해주면 dp[i][j]를 구할 수 있다.
 * 4. 연산이 종료되면 dp[N-1][i]에는 N번째 줄의 i번째로 내려오는 경로 중 가장 큰 값들이 저장되어 있을 것이고 이중 가장 큰 값이 답이 된다.
*/

using namespace std;
int N;
int dp[501][501];
int val[501][501];

int main(void){

    cin >> N;

    for(int i = 0; i < N; i++){
        for (int j = 0; j <= i; j++){
            cin >> val[i][j];
        }
    }

    dp[0][0] = val[0][0];

    for(int i = 1; i < N; i++) {
        for(int j = 0; j <= i; j++){
            if(j == 0){
                dp[i][j] = dp[i-1][j] + val[i][j];
            }
            else if(i == j){
                dp[i][j] = dp[i-1][j-1] + val[i][j];
            }
            else{
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) + val[i][j];
            }
        }
    }
    int result = 0;

    for(int i = 0; i < N; i++){
        result = max(result, dp[N-1][i]);
    }

    cout << result;

    return 0;
}