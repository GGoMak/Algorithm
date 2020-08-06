#include <iostream>

/*
 * 비타알고 2020년 3월 4주차 1번 : 망가진 에라토스테네스의 체(난이도 2)
 * 수학
 */

using namespace std;

long long N;

bool isPrime(long long num){

    if(num == 1){
        return false;
    }

    for(long long i = 2; i * i <= num; i++){
        if(num % i == 0){
            return false;
        }
    }

    return true;
}

int main(void){

    cin >> N;

    for(long long i = 2; i * i <= N; i++){
        if(N % i == 0){
            if(isPrime(i) && isPrime(N / i)){   // N이 두 수의 곱으로 이루어져 있고 두 수가 소수라면 소수로 판별
                cout << 1;
                return 0;
            }
            else{                                     // N이 두 수의 곱으로 이루어져 있지만 두 수가 모두 소수가 아니라면 합성수 판별
                cout << 0;
                return 0;
            }
        }
    }

    cout << 1;

    return 0;
}