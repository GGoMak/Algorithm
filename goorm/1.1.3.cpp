#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

/*
 * 비타알고 2020년 1월 1주차 3번 : 울타리 만들기(난이도 3)
 * 볼록 다각형을 찾는 컨벡스 헐(Convex Hull) 알고리즘
 * 1. 맨 아래 왼쪽에 위치한 점을 기준점으로 잡습니다.
 * 2. 기준점을 기준으로 각도순(반시계방향)으로 점들의 순서를 정렬합니다.
 * 3. 이후 스택에 점을 삽입하고 2개 이상이 되면 스택의 가장 위에 있는 두개의 점과 다음 점을 이용하여
 *    CCW 알고리즘으로 값을 구하고 양수라면 스택에 넣고 아니라면 가장 마지막에 스택에 넣은 점을 뺍니다.
 */

using namespace std;
int N;
vector<pair<int, int>> point;
vector<pair<int, int>> st;

long long ccw(pair<int, int> a, pair<int, int> b, pair<int, int> c){
    return ((b.first - a.first) * (c.second - a.second) - (b.second - a.second) * (c.first - a.first));
}

int main(){

    cin >> N;

    for(int i = 0; i < N; i++){
        int p, q;
        cin >> p >> q;
        point.push_back(make_pair(p, q));
    }

    // 기준점 잡기
    for(int i = 0; i < N; i ++){
        if(point[i].second <= point[0].second)
            if(point[i].first <= point[0].first){
                swap(point[0], point[i]);
            }
    }

    // 점들을 반시계 방향으로 정렬
    for(int i = 1; i < N; i++){
        for(int j = i; j < N; j++) {
            int res = ccw(point[0], point[i], point[j]);
            if(res < 0){
                swap(point[i], point[j]);
            }
            else if(res == 0){
                int a = pow((point[i].first - point[0].first), 2) + pow((point[i].second - point[0].second), 2);
                int b = pow((point[j].first - point[0].first), 2) + pow((point[j].second - point[0].second), 2);

                if(a > b){
                    swap(point[i], point[j]);
                }
            }
        }
    }

    // 첫번째, 두번째 점 스택에 삽입
    st.push_back(point[0]);
    st.push_back(point[1]);

    for(int i = 2; i < N; i++){
        // 스택의 크기가 2 이상이고 ccw가 양수가 아니라면 스택의 마지막 원소 삭제(오목다각형을 만드는 점을 제거)
        while(st.size() >= 2 && ccw(st[st.size() - 2], st[st.size() - 1], point[i]) <= 0){
            st.pop_back();

        }

        // 양수라면 점 추가(볼록다각형을 만드는 점 추가)
        st.push_back(point[i]);
    }

    cout << st.size();

    return 0;
}