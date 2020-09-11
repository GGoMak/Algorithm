#include <string>
#include <iostream>
#include <vector>

/*
 * 2019 KAKAO 개발자 겨울 인턴쉽 : 튜플
 * 구현
*/

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    string ss = s.substr(1, s.size() - 2);
    vector<vector<int>> input;

    for(int i = 0; i < ss.size(); i++){
        if(ss[i] == '{'){
            vector<int> t;
            while(ss[i] != '}') {
                i++;
                string snum = "";
                while (ss[i] != ',' && ss[i] != '}') {
                    snum += ss[i];
                    i++;
                }
                t.push_back(stoi(snum));
            }
            input.push_back(t);
        }
    }

    vector<vector<int>> sinput;

    for(int i = 1; i <= input.size(); i++){
        for(int j = 0; j < input.size(); j++){
            if(input[j].size() == i){
                sinput.push_back(input[j]);
            }
        }
    }

    for(int j = 0; j < input.size(); j++){
        if(sinput[j].size() == 1){
            answer.push_back(sinput[j][0]);
        }
        else{
            for(int p = 0; p < answer.size(); p++){
                int num = answer[p];
                for(int q = 0; q < sinput[j].size(); q++){
                    if(num == sinput[j][q]){
                        sinput[j].erase(sinput[j].begin() + q);
                        break;
                    }
                }
            }
            answer.push_back(sinput[j][0]);
        }
    }

    return answer;
}

int main(void){
    string s;

    cin >> s;

    vector<int> res = solution(s);

    for(int i = 0; i < res.size(); i++){
        cout << res[i]<< " ";
    }

    return 0;
}