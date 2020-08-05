#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 비타알고 2020년 3월 3주차 1번 : Dance Dance Revolution(난이도 2)
 * 구현
 *
 * 입력값의 범위가 10^9이기 때문에 배열을 이용한 저장방법으로는 공간복잡도 초과
 * upper_bound와 lower_bound를 이용하여 중복되는 원소의 개수를 구함
*/

using namespace std;

int N;
vector<int> v;

int main(){

    cin >> N;

    for(int i = 0; i < N; i++) {
        int a, b;
        cin >> a >> b;
        v.push_back(b);
    }

    sort(v.begin(), v.end());

    for(int i = 0; i < N; i++){
        int l = upper_bound(v.begin(), v.end(), v[i]) - lower_bound(v.begin(), v.end(), v[i]);

        if(l > 2){
            cout << 0;
            return 0;
        }

        i += (l - 1);
    }

    cout << 1;

    return 0;
}