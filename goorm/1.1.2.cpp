#include <iostream>
#include <vector>
#include <cstdlib>
#include <algorithm>

/*
 * 비타알고 2020년 1월 1주차 2번 : 이 땅은 이제 제 겁니다(난이도 3)
 * 점 3개의 방향성을 나타내는 CCW 알고리즘
 *
 *         | x1 y1 1 |
 * 2 * S = | x2 y2 1 | = x1y2 + x3y1 + x2y3 - (x3y2 + x1y3 + x2y1) = (x2 - x1)(y3 - y1) - (y2 - y1)(x3 - x1)
 *         | x3 y3 1 |
 *
 * N각형은 N-1개의 삼각형으로 이루어져 있기 때문에 삼각형의 넓이를 구해서 더하면 다각형의 넓이를 구할 수 있다.
 * 삼각형의 넓이는 CCW를 이용하여 구할 수 있으며 S가 삼각형의 넓이가 된다.
 * 외적의 크기가 세 점의 위치에 따라 양수, 음수, 0이 나올 수 있지만 쭉 더해나가고 마지막에 절댓값을 취하면 더해지는 부분과 빼지는 부분이 계산이 진행된다.
 *
 * 외적의 계산은 모두 정수이기 때문에 결과도 정수이고 따라서 마지막에 절반을 나누어 주는 과정에서 홀수인 경우 1을 더해주고 짝수인 경우 0을 더해주 반올림을 쉽게 처리할 수 있다.
 */

using namespace std;
int N;
vector<pair<int, int>> v;

long long ccw(pair<int, int> a, pair<int, int> b, pair<int, int> c){
    return ((b.first - a.first) * (c.second - a.second) - (b.second - a.second) * (c.first - a.first));
}

int main(){

    long long num = 0;

    cin >> N;

    for(int i = 0; i < N; i++){
        int p, q;
        cin >> p >> q;
        v.push_back(make_pair(p, q));
    }

    v.push_back(make_pair(v[0].first, v[0].second));

    for(int i = 1; i < N - 1; i++){
        num += ccw(v[0], v[i], v[i + 1]);
    }

    num = abs(num);
    cout << (num / 2) + (num % 2);

    return 0;
}