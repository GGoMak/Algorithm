#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 백준 14501번 : 퇴사(47%)
 * DP
 */

using namespace std;
int N;
int dp[1001];
vector<pair<int, int>> v(1001);

int main(void){

    cin >> N;

    for(int i = 1; i <= N; i++){
        cin >> v[i].first >> v[i].second;
    }

    for(int i = N; i > 0; i--){
        if(i + v[i].first > N + 1){
            dp[i] = dp[i + 1];
        }
        else{
            dp[i] = max(dp[i + 1], v[i].second + dp[i + v[i].first]);
        }
    }

    cout << dp[1];

    return 0;
}
