#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 비타알고 2020년 1월 1주차 1번 : 다음 타겟(난이도 2)
 * 점 3개의 방향성을 나타내는 CCW 알고리즘
 *
 *         | x1 y1 1 |
 * 2 * S = | x2 y2 1 | = x1y2 + x3y1 + x2y3 - (x3y2 + x1y3 + x2y1) = (x2 - x1)(y3 - y1) - (y2 - y1)(x3 - x1)
 *         | x3 y3 1 |
 *
 * S > 0 반시계 방향으로 위치
 * S = 0 일직선에 위치
 * S < 0 시계 방향으로 위치
 */

using namespace std;
int N;
vector<pair<double, double>> a, b, c;

int ccw(pair<double, double> a, pair<double, double> b, pair<double, double> c){

    double S = ((b.first - a.first) * (c.second - a.second) - (b.second - a.second) * (c.first - a.first));

    if(S > 0)
        return 1;
    else if(S < 0)
        return 2;
    else
        return 3;
}

int main(){

    cin >> N;

    for(int i = 0; i < N; i++){
        double p, q;
        cin >> p >> q;
        a.push_back(make_pair(p, q));
        cin >> p >> q;
        b.push_back(make_pair(p, q));
        cin >> p >> q;
        c.push_back(make_pair(p, q));
    }

    for(int i = 0; i < N; i++){
        cout << ccw(a[i], b[i], c[i]) << endl;
    }

    return 0;
}