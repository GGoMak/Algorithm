#include <iostream>
#include <algorithm>
#include <climits>
/*
 * 백준 16637번 : 괄호 추가하기(35%)
 * 구현
 */

using namespace std;
int N;
string input;
int res = -INT_MAX;

int cal(int x, int y, char oper){

    if(oper == '+'){
        return x + y;
    }
    else if(oper == '-'){
        return x - y;
    }
    else if(oper == '*'){
        return x * y;
    }
}

void dfs(int index, int sum){

    if(index > N - 1){
        res = max(res, sum);
        return;
    }

    char oper;

    if(index == 0){
        oper = '+';
    }
    else{
        oper = input[index - 1];
    }

    // 현재 인덱스를 괄호로 묶을 경우
    if(index + 2 < N){
        int tmp = cal(input[index] - '0', input[index + 2] - '0', input[index + 1]);
        dfs(index + 4, cal(sum, tmp, oper));
    }

    // 괄호로 묶지 않을 경우
    dfs(index + 2, cal(sum, input[index] - '0', oper));
}

int main(void){

    cin >> N;
    cin >> input;

    dfs(0, 0);

    cout << res;

    return 0;
}
