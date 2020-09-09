#include <vector>
#include <iostream>
#include <algorithm>

/*
 * 2019 KAKAO BLIND RECRUITMENT : 길 찾기 게임(7.4%)
 * 구현
*/

using namespace std;

vector<int> prefix;
vector<int> postfix;
vector<pair<int, int>> q[100001];

void find(int s, int e, int d){

    if(d < 0){
        return;
    }

    int check = 1;

    for(int k = d; k >= 0; k--) {
        for (int i = 0; i < q[k].size(); i++) {
            if (s <= q[k][i].first && q[k][i].first <= e && check) {
                prefix.push_back(q[k][i].second);
                int nn = q[k][i].first;
                find(s, nn, k - 1);
                find(nn + 1, e, k - 1);
                postfix.push_back(q[k][i].second);
                q[k].erase(q[k].begin());
                check = 0;
            }
        }
    }
}

vector<vector<int>> solution(vector<vector<int>> nodeinfo) {
    vector<vector<int>> answer;
    int d = 0;

    for(int i = 0 ; i < nodeinfo.size(); i++){
        q[nodeinfo[i][1]].push_back(make_pair(nodeinfo[i][0], i + 1));
        if(d < nodeinfo[i][1]){
            d = nodeinfo[i][1];
        }
    }

    for(int i = 0; i < d; i++){
        sort(q[i].begin(), q[i].end());
    }

    prefix.push_back(q[d][0].second);
    find(0, q[d][0].first, d - 1);
    find(q[d][0].first + 1, 100000, d - 1);
    postfix.push_back(q[d][0].second);

    answer.push_back(prefix);
    answer.push_back(postfix);

    return answer;
}

int main(void){
    int N;

    cin >> N;
    vector<vector<int>> v;
    for(int i = 0; i < N; i++){
        vector<int> t;
        int a, b;
        cin >> a >> b;
        t.push_back(a);
        t.push_back(b);
        v.push_back(t);
    }

    vector<vector<int>> res = solution(v);

    for(int i = 0; i < res.size(); i++){
        for(int j = 0; j < res[i].size(); j++){
            cout << res[i][j];
        }
        cout << endl;
    }
}