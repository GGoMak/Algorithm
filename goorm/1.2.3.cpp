#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 비타알고 2020년 1월 2주차 3번 : 비밀번호 찾기(난이도 2)
 * 탐욕 알고리즘
 *
 * 1. 수열 중 가장 큰 수는 우선 답이 된다.
 * 2. 수열중 가장 큰 수의 약수를 제외한 다른 수의 약수를 찾으면 그중에서 가장 큰 수가 답이다.
 */

using namespace std;
int N;
vector<int> b; // 나머지 약수를 넣는 배열

int main(){

    int num;

    cin >> N;
    vector<int> a(N);

    for(int i = 0; i < N; i++){
        cin >> a[i];
    }

    sort(a.begin(), a.end());

    int bSize = 0;  // b배열의 크기

    for(int i = 0; i < N; i++){
        if(a[N-1] % a[i] == 0){     // 가장 큰 수의 약수이고
            if(a[i] == a[i+1]){     // 같은 수가 2개이면 둘중 하나는 다른 수의 약수이므로 b배열에 넣어준다.
                b.push_back(a[i]);
                i++;
                bSize++;
            }
        }
        else{                       // 가장 큰 수의 약수가 아니면 다른 수의 약수이므로 b배열에 넣어준다.
            b.push_back(a[i]);
            bSize++;
        }
    }

    cout << b[b.size() - 1] << " " << a[N - 1];

    return 0;
}