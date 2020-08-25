#include <iostream>
#include <string>
#include <vector>

/*
 * 비타알고 2020년 4월 3주차 2번 : Ctrl+F(난이도 3)
 * KMP 알고리즘
*/

using namespace std;
string str1, str2;
vector<int> f;

void getFail(){

    f.resize(str2.length());
    f[0] = 0;

    int j = 0, n = str2.size();

    for(int i = 1; i < n; i++){
        while(j > 0 && str2[i] != str2[j]){
            j = f[j - 1];
        }

        if(str2[i] == str2[j]){
            f[i] = ++j;
        }
        else{
            f[i] = 0;
        }
    }
}

int main(void){

    cin >> str1;
    cin >> str2;

    getFail();

    vector<int> result;

    int j = 0;
    int n = str1.size(), m = str2.size();

    for(int i = 0; i < n; i++){
        while(j > 0 && str1[i] != str2[j]){
            j = f[j - 1];
        }

        if(str1[i] == str2[j]){
            if(j == m - 1){
                result.push_back(i - m + 1);
                j = f[j];
            }
            else{
                j++;
            }
        }
    }

    for(int i = 0; i < result.size(); i++){
        printf("%d\n", result[i] + 1);
    }

    return 0;
}