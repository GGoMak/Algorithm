#include <iostream>
/*
 * 비타알고 2020년 2월 2주차 1번 : 홍자TV(난이도 2)
 */

using namespace std;
long long a, b, N;

int main(void){

    cin >> a >> b >> N;
    long long num = 0;
    long long result = 0;

    while(num < N){
        num += a;
        if(num >= N){
            result++;
            break;
        }
        num -= b;
        result++;
    }

    cout << result;

    return 0;
}

/*  이분탐색 풀이법

using namespace std;
int a, b, N;

bool check(long long mid, long long a, long long b, long long N){
    return ((a * mid) - (b * (mid - 1))) >= N;
}

int main(void){
    cin >> a >> b >> N;

    long long l = 1, r = 1000000000;
    long long result = 1000000000;
    long long mid;

    while(l <= r){
        mid = (l + r) / 2;
        if(check(mid, a, b, N)){
            result = min(result, mid);
            r = mid - 1;
        }
        else{
            l = mid + 1;
        }
    }

    cout << result;

    return 0;
}
 */