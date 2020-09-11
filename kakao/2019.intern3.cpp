#include <iostream>
#include <vector>
#include <set>

/*
 * 2019 KAKAO 개발자 겨울 인턴쉽 : 불량 사용자
 * 구현
 *
 * 비트마스크
*/

using namespace std;

bool compare(string banned_id, string user_id){

    if(banned_id.size() != user_id.size()){
        return false;
    }

    for(int i = 0; i < user_id.size(); i++){
        if(user_id[i] != banned_id[i] && banned_id[i] != '*'){
            return false;
        }
    }

    return true;
}

int solution(vector<string> user_id, vector<string> banned_id) {
    int answer = 0;
    int n = user_id.size();
    int m = banned_id.size();
    vector<vector<int>> v;

    for(int i = 0; i < m; i++){
        vector<int> t;
        for(int j = 0; j < n; j++){
            if(compare(banned_id[i], user_id[j])){
                int k = (1 << j);
                t.push_back(k);
            }
        }
        v.push_back(t);
    }

    for(int i = 0; i < v.size() - 1; i++){
        set<int> s;

        for(int p = 0; p < v[i].size(); p++){
            for(int q = 0; q < v[i + 1].size(); q++){
                if((v[i][p] | v[i + 1][q]) != v[i][p]){
                    s.insert(v[i][p] | v[i + 1][q]);
                }
            }
        }

        v[i + 1].erase(v[i + 1].begin(), v[i + 1].end());

        set<int>::iterator iter;
        for (iter = s.begin(); iter != s.end(); ++iter){
            v[i + 1].push_back(*iter);
        }
    }

    answer = v[banned_id.size() - 1].size();

    return answer;
}

int main(void) {

    int n, m;
    cin >> n >> m;
    vector<string> user_id, banned_id;
    for(int i = 0; i < n; i++){
        string a;
        cin >> a;
        user_id.push_back(a);
    }

    for(int i = 0; i < m ;i++){
        string a;
        cin >> a;
        banned_id.push_back(a);
    }

    cout << solution(user_id, banned_id);

    return 0;
}