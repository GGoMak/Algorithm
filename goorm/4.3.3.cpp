#include <iostream>
#include <string>
#include <vector>

/*
 * 비타알고 2020년 4월 3주차 3번 : 검색엔진(난이도 3)
 * KMP 알고리즘
*/

using namespace std;

vector<int> getFail(string str){

     int n = str.size(), j = 0;
     vector<int> f(n);
     f[0] = 0;

     for(int i = 1; i < n; i++){
         while(j > 0 && str[i] != str[j]){
             j = f[j - 1];
         }

         if(str[i] == str[j]) {
             f[i] = ++j;
         }
         else{
             f[i] = 0;
         }
     }

     return f;
}

int main(void){

    string str;

    cin >> str;
    int n = str.size();
    int result = 0;

    for(int i = 0; i < n; i++){
        string input = str.substr(n - i - 1, 3000);
        vector<int> f = getFail(input);

        int num = 0;

        for(int j = 0; j < f.size(); j++){
            num = max(num, f[j]);
        }

        result = max(num, result);

    }

    cout << result;

    return 0;
}