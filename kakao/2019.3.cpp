#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <set>
#include <algorithm>

/*
 * 2019 KAKAO BLIND RECRUITMENT : 후보키(16%)
 * 구현
 *
 * 비트마스크 + set
*/

using namespace std;

bool check(vector<int> v, int n){

    for(int i = 0; i < v.size(); i++){
        if((v[i] & n) == v[i]){
            return false;
        }
    }

    return true;
}

int solution(vector<vector<string>> relation) {
    int answer = 0;
    int row = relation.size();
    int col = relation[0].size();
    vector<int> res;

    for(int i = 1; i < (1 << col); i++){
        set<string> s;
        for(int j = 0; j < row; j++){
            string str = "";
            for(int k = 0; k < col; k++){
                if(i & (1 << k)){
                    str += relation[j][k];
                }
            }

            s.insert(str);
        }

        if(s.size() == row && check(res, i)){
            res.push_back(i);
        }
    }

    answer = res.size();

    return answer;
}

int main(void) {

    int c, r;
    vector<vector<string>> v;
    cin >> c >> r;

    for(int i = 0; i < r; i++){
        vector<string> t;
        for(int j = 0; j < c; j++){
            string a;
            cin >> a;
            t.push_back(a);
        }
        v.push_back(t);
    }

    cout << solution(v);

    return 0;
}