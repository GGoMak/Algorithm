#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 2020 KAKAO BLIND RECRUITMENT : 가사 검색(34.4%)
 * 구현
 *
 * 효율성 통과 x
*/

using namespace std;

bool check(string query, string word){

    if(query.size() != word.size()){
        return false;
    }

    for(int i = 0; i < query.size(); i++){
        if(query[i] != '?' && query[i] != word[i]){
            return false;
        }
    }

    return true;
}

vector<int> solution(vector<string> words, vector<string> queries){
    vector<int> answer;

    for(int i = 0; i < queries.size(); i++){
        int res = 0;
        for(int j = 0; j < words.size(); j++){
            if(check(queries[i], words[j])){
                res++;
            }
        }
        answer.push_back(res);
    }

    return answer;
}

int main(void) {

    vector<string> words, queries;
    int N, M;
    cin >> N >> M;

    for(int i = 0; i < N; i++){
        string a;
        cin >> a;
        words.push_back(a);
    }
    for(int i = 0; i < M; i++){
        string a;
        cin >> a;
        queries.push_back(a);
    }

    vector<int> result = solution(words, queries);

    for(int i = 0; i < result.size(); i++){
        cout << result[i] << endl;
    }

    return 0;
}