#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 비타알고 2020년 3월 2주차 1번 : 경품 추첨(난이도 2)
 *
 * 구현
 * 3.1.2.cpp(화학약품) 문제와 같은 방식으로 upper_bound와 lower_bound를 이용하여 중복된 원소의 갯수를 세어주면 쉽게 풀이할 수 있음.
*/

using namespace std;

int N, M;
vector<int> a;

int main(void){

    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> M;

    for(int i = 0; i < N; i++) {
        int num;
        cin >> num;
        a.push_back(num);
    }
    sort(a.begin(), a.end());

    for(int i = 0; i < M; i++){
        int num;
        cin >> num;

        int count = upper_bound(a.begin(), a.end(), num) - lower_bound(a.begin(), a.end(), num);

        cout << count << " ";
    }

    return 0;
}