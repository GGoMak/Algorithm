#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

/*
 * 비타알고 2020년 3월 1주차 2번 : 화학약품(난이도 3)
 * 완전탐색 + 투 포인터 + 비트마스크 연산
 *
 * 40개를 모두 확인할라면 2^40의 시간이 걸리기 때문에 두개의 부분집합으로 나누어 계산한다. 여기서는 홀수번째 원소 짝수번째 원소로 나누었다.
 * 나누어진 부분집합에 대해 각각 부분합을 구하는데 한쪽 부분집합의 원소를 사용하지 않는 경우가 있기 때문에 공집합을 의미하는 0을 추가하고 정렬한다.
 * b[0]부분 집합은 시작부터 b[1]부분 집합은 끝부터 계산하여 합이 0인 경우를 찾는다.
 * 단, 같은 원소가 존재할 경우가 있기 때문에 upper_bound와 lower_bound를 사용하여 원소의 개수를 구하여 그 경우를 계산하여 준다.
*/

using namespace std;
int N;
vector<int> a[2];   // 입력받은 원소
vector<int> b[2];   // 부분합 배열

long long count(vector<int> &a, int num){
    // upper_bound를 통해 중복되는 원소의 가장 끝의 위치가 나오고
    // lower_bound를 통해 가장 처음의 위치가 나온다
    // 이 둘의 차이를 구하면 중복되는 원소의 개수를 구할 수 있다.
    return upper_bound(a.begin(), a.end(), num) - lower_bound(a.begin(), a.end(), num);
}

int main(){

    cin >> N;

    for(int i = 0; i < N; i++){
        int num;
        cin >> num;
        a[i % 2].push_back(num);
    }

    for(int i = 0; i < 2; i++){ // 부분합 배열 만들기
        for(int j = pow(2, a[i].size()); j > 0; j--){
            int sum = 0;
            for(int k = 0; k < a[i].size(); k++){
                if(j & (1 << k)){
                    sum += a[i][k];
                }
            }
            b[i].push_back(sum);
        }
        sort(b[i].begin(), b[i].end()); // 정렬
    }

    auto l = b[0].begin();
    auto r = b[1].end() - 1;
    long long result = 0;

    while(l <= b[0].end() && r >= b[1].begin()){
        if(*l + *r == 0){
            result += count(b[0], *l) * count(b[1], *r);    // 중복되는 경우 찾기
            l = upper_bound(b[0].begin(), b[0].end(), *l);
            r = lower_bound(b[1].begin(), b[1].end(), *r) - 1;
        }
        else if(*l + *r > 0){
            r--;
        }
        else{
            l++;
        }
    }

    cout << result - 1;

    return 0;
}