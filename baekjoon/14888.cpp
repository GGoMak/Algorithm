#include <iostream>
#include <vector>
#include <climits>

/*
 * 백준 14888번 : 연산자 끼워넣기(50%)
 * 완전탐색
 */

using namespace std;
int N;
vector<int> A;
int oper[4];
int maxi = -INT_MAX, mini = INT_MAX;

int cal(int a, int b, int opera){

    if(opera == 0){
        return a + b;
    }
    else if(opera == 1){
        return a - b;
    }
    else if(opera == 2){
        return a * b;
    }
    else{
        return a / b;
    }
}

void dfs(int n, int sum){

    if(n == N - 1){
        maxi = max(maxi, sum);
        mini = min(mini, sum);
        return;
    }

    for(int i = 0; i < 4; i++){
        if(oper[i] > 0){
            oper[i]--;
            dfs(n + 1, cal(sum, A[n + 1], i));
            oper[i]++;
        }
    }
}

int main(void){

    cin >> N;

    for(int i = 0; i < N; i++){
        int a;
        cin >> a;
        A.push_back(a);
    }

    cin >> oper[0] >> oper[1] >> oper[2] >> oper[3];

    dfs(0, A[0]);

    cout << maxi << endl;
    cout << mini;

    return 0;
}
