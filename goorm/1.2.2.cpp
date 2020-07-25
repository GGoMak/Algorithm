#include <iostream>
#include <vector>

/*
 * 비타알고 2020년 1월 2주차 2번 : 수열 만들기(난이도 3)
 * 그리디 알고리즘 + 투 포인터
 */

using namespace std;
int N, M;
vector<int> a, b;

int main(){

    cin >> N;

    for(int i = 0; i < N; i++){
        int x;
        cin >> x;
        a.push_back(x);
    }

    cin >> M;

    for(int i = 0; i < M; i++){
        int y;
        cin >> y;
        b.push_back(y);
    }

    int p = 0, q = 0;
    int result = 0;

    while(p < N && q < M){
        if(a[p] == b[q]){
            result++;
            p++;
            q++;
        }
        else{
            if(a[p] > b[q]){
                b[q+1] += b[q];
                q++;
            }
            else{
                a[p+1] += a[p];
                p++;
            }
        }
    }

    if(result == 0){
        cout << "-1" << endl;
    }
    else{
        cout << result << endl;
    }

    return 0;
}