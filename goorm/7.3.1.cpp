#include <iostream>
#include <algorithm>

/*
 * 비타알고 2020년 7월 3주차 1번 : 앞뒤가 똑같은 부분 문자열(난이도 3)
 * 회문(Palindrome) 문제로 입력이 100,000이상이기 때문에 O(n)의 시간 복잡도를 가지는 Manacher 알고리즘으로 풀이
 * 해설 : https://edu.goorm.io/learn/lecture/18444/%EC%8B%9C%EC%A6%8C3-%EC%97%B0%EC%9E%AC-%EC%A4%91-%EC%9C%84%ED%81%B4%EB%A6%AC-%EB%B9%84%ED%83%80%EC%95%8C%EA%B3%A0-%EC%A4%91%EA%B8%89%ED%8E%B8/lesson/1036811/%EB%A7%88%EB%82%98%EC%BB%A4-manacher-s-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 */

using namespace std;

int d[200003] = {0};

int main(){

    int result = -1, r = 0, c = 0;
    string str;

    cin >> str;

    for(int i = str.length() - 1; i >= 0; i--){
        str.insert(i, "#");
    }
    str.append("#");

    for(int i = 0; i < str.length(); i++){
        if(i <= r){
            d[i] = min(d[c * 2 - i], r - i);
        }
        else{
            d[i] = 0;
        }

        while(i - d[i] - 1 >= 0 && i + d[i] + 1 < str.length() && str[i - d[i] - 1] == str[i + d[i] + 1]){
            d[i]++;
        }

        if(r < i + d[i]){
            r = i + d[i];
            c = i;
        }
    }

    for(int i = 0; i < str.length(); i++){
        result = max(result, d[i]);
    }

    cout << result;

    return 0;
}