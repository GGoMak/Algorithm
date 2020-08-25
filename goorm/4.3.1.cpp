#include <iostream>
#include <string>

/*
 * 비타알고 2020년 4월 3주차 1번 : 회문(난이도 3)
 * Manacher 알고리즘
*/

using namespace std;
string str;
int N;

bool manacher(string s){

    int A[10001];
    int r = 0, p = 0;

    for(int i = 0; i < s.length(); i++){
        A[i] = 0;
    }

    for(int i = 0; i < s.length(); i++){
        if(i <= r){
            A[i] = min(A[p * 2 - i], r - i);
        }
        else{
            A[i] = 0;
        }

        while(s[i - A[i] - 1] == s[i + A[i] + 1] && i - A[i] - 1 >= 0 && i + A[i] + 1 < s.length()){
            A[i]++;
        }

        if(r < i + A[i]){
            r = i + A[i];
            p = i;
        }
    }

    int check = -1;

    for(int i = 0; i < s.length(); i++){
        check = max(A[i], check);
    }

    if(check == s.length() / 2){
        return true;
    }
    else{
        return false;
    }
}

int main(void){

    cin >> str;
    cin >> N;

    for(int i = 0; i < N; i++){
        int a, b;
        cin >> a >> b;
        string tmp = str.substr(a - 1, b - a + 1);
        string str1;

        for(int i = 0; i < b - a + 1; i++){
            str1 += "#";
            str1 += tmp[i];
        }
        str1 += "#";

        bool result = manacher(str1);

        if(result){
            cout << "1" << endl;
        }
        else{
            cout << "0" << endl;
        }
    }

    return 0;
}