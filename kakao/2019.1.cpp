#include <iostream>
#include <vector>
#include <sstream>
#include <map>
#include <algorithm>

/*
 * 2019 KAKAO BLIND RECRUITMENT : 오픈채팅방(59%)
 * 구현
 *
 * HashMap 활
*/

using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    map<string, string> m;

    for(int i = 0; i < record.size(); i++) {
        stringstream stream(record[i]);
        string state, uid, name;

        stream >> state;
        stream >> uid;
        stream >> name;

        if(state == "Enter"){
            m[uid] = name;
        }
        else if(state == "Change"){
            m[uid] = name;
        }
    }

    for(int i = 0; i < record.size(); i++){
        stringstream stream(record[i]);
        string state, uid, name;

        stream >> state;
        stream >> uid;

        if(state == "Enter") {
            answer.push_back(m[uid]+"님이 들어왔습니다.");
        }
        else if(state == "Leave"){
            answer.push_back(m[uid]+"님이 나갔습니다.");
        }
    }

    return answer;
}

int main(void) {

    vector<string> t;

    for(int i = 0; i < 5; i++){
        string a;
        getline(cin, a);
        t.push_back(a);
    }

    vector<string> res = solution(t);

    for(int i = 0; i < res.size();i++){
        cout << res[i] << endl;
    }

    return 0;
}