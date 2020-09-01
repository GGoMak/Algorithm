#include <iostream>
#include <algorithm>

/*
 * 2020 KAKAO BLIND RECRUITMENT : 문자열 압축(25%)
 * 구현
*/

using namespace std;

int solution(string s) {
    int answer = 987654321;

    if(s.size() == 1){
        return 1;
    }

    for(int i = 1; i <= s.size() / 2; i++){
        string resStr;
        string str1 = s.substr(0, i);
        int count = 1;

        for(int j = i; j < s.size(); j += i) {
            string str2 = s.substr(j, i);

            if (str1 == str2) {
                count++;
            }
            else {
                if(count == 1){
                    resStr += str1;
                }
                else {
                    resStr += to_string(count) + str1;
                }

                str1 = s.substr(j, i);
                count = 1;
            }

            if(i + j >= s.size()){
                if(count == 1){
                    resStr += str1;
                }
                else{
                    resStr += to_string(count) + str1;
                }
            }
        }

        answer = min(answer, (int)resStr.size());
    }


    return answer;
}

int main(void) {

    string s;

    cin >> s;

    cout << solution(s);

    return 0;
}