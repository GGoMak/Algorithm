#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 2019 KAKAO BLIND RECRUITMENT : 실패율(55%)
 * 구현
 *
 * upper_bound, lower_bound로 원소의 갯수 검색
*/

using namespace std;
vector<pair<int, double>> fail;

bool compare(pair<int, double> a, pair<int, double> b){
    if(a.second != b.second) {
        return a.second > b.second;
    }
    else {
        return a.first < b.first;
    }
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;

    sort(stages.begin(), stages.end());

    int cnt = stages.size();

    for(int i = 1; i <= N; i++){
        int end = upper_bound(stages.begin(), stages.end(), i) - stages.begin();
        int start = lower_bound(stages.begin(), stages.end(), i) - stages.begin();

        if(cnt == 0){
            fail.push_back(make_pair(i, 0));
        }
        else {
            fail.push_back(make_pair(i, (double) (end - start) / cnt));
        }
        cnt -= (end - start);
    }

    sort(fail.begin(), fail.end(), compare);

    for(int i = 0; i < N; i++){
        answer.push_back(fail[i].first);
    }

    return answer;
}

int main(void) {

    int n, m;
    vector<int> stages;

    cin >> n >> m;

    for(int i = 0; i < m; i++){
        int a;
        cin >> a;
        stages.push_back(a);
    }

    vector<int> res = solution(n, stages);

    for(int i = 0; i < res.size(); i++){
        cout << res[i] << " ";
    }

    return 0;
}