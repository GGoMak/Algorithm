#include <iostream>
#include <queue>

/*
 * 백준 13458번 : 시험 감독(25%)
 * 구현
 */

using namespace std;
int N, B, C;
vector<int> A;

int main(void){

    cin >> N;

    for(int i = 0; i < N; i++){
        int a;
        cin >> a;
        A.push_back(a);
    }

    cin >> B >> C;

    long long res = 0;

    for(int i = 0; i < N; i++){

        A[i] -= B;
        res += 1;

        if(A[i] <= 0){
            continue;
        }

        if(A[i] % C != 0){
            res += 1;
        }

        res += (A[i] / C);
    }

    cout << res;

    return 0;
}