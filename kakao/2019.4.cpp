#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 2019 KAKAO BLIND RECRUITMENT : 무지의 먹방 라이브(42%)
 * 구현
 *
 * 효율성 통과
*/

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b){
    return a.second < b.second;
}

int solution(vector<int> food_times, long long k) {
    int answer = 0;

    vector<pair<int, int>> v;

    for(int i = 1; i <= food_times.size(); i++){
        v.push_back(make_pair(food_times[i-1], i));
    }

    sort(v.begin(), v.end());

    for(int i = 0; i < food_times.size(); i++) {
        long long num = (i == 0) ? v[0].first * v.size() : (v[i].first - v[i - 1].first) * (v.size() - i);

        if(k - num >= 0){
            k -= num;
        }
        else{
            k %= (v.size() - i);
            sort(v.begin() + i, v.end(), compare);
            return v[i + k].second;
        }
    }

    return -1;
}

int main(void) {

    int n, k;

    cin >> n >> k;
    vector<int> v;

    for(int i = 0; i < k; i++){
        int a;
        cin >> a;
        v.push_back(a);
    }

    cout << solution(v, n);

    return 0;
}