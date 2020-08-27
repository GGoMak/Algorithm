#include <iostream>
#include <algorithm>
#include <cmath>

/*
 * 백준 15954번 : 인형들(18%)
 * 구현
*/

using namespace std;
int N, K;
int input[502];

double getSD(int start, int k){

    double tmp = 0;
    double avg, var, sd;

    for(int i = start; i < start + k; i++){
        tmp += input[i];
    }

    avg = tmp / k;
    tmp = 0;

    for(int i = start; i < start + k; i++){
        tmp += (input[i] - avg) * (input[i] - avg);
    }

    var = tmp / k;
    sd = sqrt(var);

    return sd;
}

int main(void){

    cin >> N >> K;

    for(int i = 0; i < N ; i++){
        cin >> input[i];
    }

    double res = 123456789;

    for(int i = K; i <= N; i++){
        for(int j = 0; j <= N - i; j++){
            res = min(res, getSD(j, i));
        }
    }

    cout.precision(11);
    cout << res;

    return 0;
}
