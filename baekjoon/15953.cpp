#include <iostream>
#include <algorithm>

/*
 * 백준 15953번 : 상금 헌터(36%)
 * 구현
 */

using namespace std;
int T;
int A[8] = {5000000, 3000000, 2000000, 500000, 300000, 100000, 0};
int nA[8] = {1, 2, 4, 7, 11, 16, 22};
int B[7] = {5120000, 2560000, 1280000, 640000, 320000, 0};
int nB[7] = {1, 2, 4, 8, 16, 32};

int main(void){

    cin >> T;

    for(int i = 0; i < T; i++){
        int a, b, res = 0;
        cin >> a >> b;

        for(int j = 0; j < 7; j++){
            if(nA[j] <= a && a < nA[j + 1]){
                res += A[j];
            }
        }
        for(int j = 0; j < 7; j++){
            if(nB[j] <= b && b < nB[j + 1]){
                res += B[j];
            }
        }
        cout << res << endl;
    }

    return 0;
}
