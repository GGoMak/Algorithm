#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 비타알고 2020년 3월 4주차 2번 : 별들의 전쟁(난이도 3)
 * DP
 *
 * dp[i] = 인구수를 i로 만들기 위해 필요한 최소 유닛 수
 * dp[i] = min(dp[i], dp[i - a(i)] + 1)  (a(i)는 i번째 유닛의 인구수)
*/

using namespace std;

int N, M;
int dp[20001];
vector<int> v;

int main(void){

    cin >> N >> M;

    for(int i = 0; i <= M; i++){    // dp배열 초기화
        dp[i] = 1e9;
    }

    for(int i = 0; i < N; i++){
        int num;
        cin >> num;
        v.push_back(num);
    }

    for(int i = 0; i < v.size(); i++){  // 초기값 세팅
        dp[v[i]] = 1;
    }

    sort(v.begin(), v.end());

    for(int i = 1; i <= M; i++){
        for(int j = 0; j < N; j++) {
            if(v[j] <= i) {
                dp[i] = min(dp[i], dp[i - v[j]] + 1);
            }
        }
    }

    if(dp[M] == 1e9){
        cout << -1;
    }
    else {
        cout << dp[M];
    }
    return 0;
}