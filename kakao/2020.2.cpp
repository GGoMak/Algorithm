#include <iostream>
#include <algorithm>

/*
 * 2020 KAKAO BLIND RECRUITMENT : 괄호 변환(23%)
 * 구현
*/

using namespace std;

bool checkRight(string s){  // 올바른 괄호 문자열인지 확인

    int lcnt = 0, rcnt = 0;

    for(int i = 0; i < s.size(); i++){
        if(s[i] == '('){
            lcnt++;
        }
        else if(s[i] == ')'){
            rcnt++;
        }

        if(lcnt < rcnt){    // 오른쪽 괄호가 왼쪽괄호보다 많아지면 올바른 문자열이 아님
            return false;
        }
    }

    return true;
}

string solution(string p) {
    string answer = "", u = "", v = "";

    int lcnt = 0, rcnt = 0, i;

    if(p == ""){    // 문자열이 ""이면 그대로 종료
        return "";
    }

    for(i = 0; i < p.size(); i++){  // u 문자열 생성
        if(p[i] == '('){
            rcnt++;
        }
        else if(p[i] == ')'){
            lcnt++;
        }

        u += p[i];

        if(lcnt == rcnt){
            break;
        }
    }

    v += p.substr(i + 1, p.size() - i); // v 문자열 생성

    if(checkRight(u)){  // u가 올바른 괄호 문자열이면 v문자열 재귀 수행
        u += solution(v);
        answer += u;
    }
    else{               // u가 올바른 괄호 문자열이 아니면 문제 제시사항에 맞게 answer 제작
        answer += '(';
        answer += solution(v);
        answer += ')';
        u = u.substr(1, u.size() - 2);

        for(int i = 0; i < u.size(); i++){
            if(u[i] == '(')
                u[i] = ')';
            else if(u[i] == ')')
                u[i] = '(';
        }

        answer += u;
    }

    return answer;
}

int main(void) {

    string s;

    cin >> s;

    cout << solution(s);

    return 0;
}