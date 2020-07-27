#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

/*
 * 비타알고 2020년 1월 3주차 1번 : 모임(난이도 2)
 * 수학, 완전탐색
 *
 * 모든 점을 이용하여 평균값을 구한다고 생각할 수 있지만 최단거리가 아닌 경우가 존재
 * 따라서 평균값이 아닌 중앙값을 이용하여 계산을 하여야함
 *
 * 1. 점의 개수가 홀수라면 정렬하고 중앙에 있는 값이 답
 * 2. 점의 개수가 짝수라면 중앙에 있는 두개의 값의 평균을 이용하여 계산, 하지만 도착지가 정수여야 하기 때문에 실수가 나오는 경우 주변값을 포함하여 탐색해야함.
 */

using namespace std;
int N, M;
vector<int> x, y;

int main(){

    cin >> N >> M;

    for(int i = 0; i < M; i++){
        int p, q;
        cin >> p >> q;
        x.push_back(p);
        y.push_back(q);
    }

    sort(x.begin(), x.end());
    sort(y.begin(), y.end());

    int result = INT_MAX;

    if(M % 2 == 1){ // 점의 개수가 홀수라면
        int resultX = x[M / 2]; // 중앙값이 도착
        int resultY = y[M / 2];
        int num = 0;

        for(int i = 0; i < M; i++){
            num += abs(x[i] - resultX) + abs(y[i] - resultY);
        }
        cout << num;
    }

    else{ // 점의 개수가 짝수라면
        for (int i = 0; i < 2; i++) {   // 주변값을 포함하여 탐색
            for (int j = 0; j < 2; j++) {
                int resultX = (x[M / 2] + x[M / 2 - 1]) / 2 + i;
                int resultY = (y[M / 2] + y[M / 2 - 1]) / 2 + j;
                int num = 0;

                for (int k = 0; k < M; k++) {
                    num += abs(x[k] - resultX) + abs(y[k] - resultY);
                }

                if (num < result) {
                    result = num;
                }
            }
        }

        cout << result;
    }

    return 0;
}