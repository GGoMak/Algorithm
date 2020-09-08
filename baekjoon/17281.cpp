#include <iostream>
#include <algorithm>

/*
 * 백준 17281번 : 야구(50%)
 * 구현
 *
 * 순열(next_permutation) 활용
 */

using namespace std;
int N;
int A[51][9];
int order[9] = {3, 0, 1, 2, 4, 5, 6, 7, 8};
int res;

int main(void){

    cin >> N;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < 9; j++){
            cin >> A[i][j];
        }
    }

    do{
        int torder[9] = { 0 };

        for(int i = 0; i < 9; i++){
            torder[order[i]] = i;
        }

        int score = 0;
        int betterIndex = 0;

        for(int inning = 0; inning < N; inning++){
            int outCount = 0;
            int base[4] = { 0 };

            while(outCount < 3){
                if(A[inning][torder[betterIndex % 9]] == 1){
                    if(base[3] == 1){
                        score++;
                    }
                    for(int j = 3; j > 1; j--){
                        base[j] = base[j - 1];
                    }
                    base[1] = 1;
                }

                else if(A[inning][torder[betterIndex % 9]] == 2){
                    for(int j = 2; j <= 3; j++){
                        if(base[j] == 1){
                            score++;
                        }
                    }
                    base[3] = base[1];
                    base[2] = 1;
                    base[1] = 0;
                }

                else if(A[inning][torder[betterIndex % 9]] == 3){
                    for(int j = 1; j <= 3; j++){
                        if(base[j] == 1){
                            score++;
                        }
                    }
                    base[3] = 1;
                    base[2] = 0;
                    base[1] = 0;
                }

                else if(A[inning][torder[betterIndex % 9]] == 4){
                    for(int j = 1; j <= 3; j++){
                        if(base[j] == 1){
                            score++;
                        }
                    }
                    base[3] = 0;
                    base[2] = 0;
                    base[1] = 0;
                    score++;
                }

                else{
                    outCount++;
                }

                betterIndex++;
            }
        }

        res = max(res, score);

    }while(next_permutation(order + 1, order + 9));

    cout << res;

    return 0;
}