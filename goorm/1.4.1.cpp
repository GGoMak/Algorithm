#include <iostream>
#include <vector>

/*
 * 비타알고 2020년 1월 4주차 1번 : 대기열(난이도 2)
 * 구현
 */

using namespace std;
int N, C;
vector<pair<int, int>> input;

int find(vector<pair<int, int>> v, int num){    //
    for(int i = 0; i < v.size(); i++){
        if(v[i].second == num){
            return i;
        }
    }

    return -1;
}

int main(){

    cin >> N;

    for(int i = 0; i < N; i++){
        int p, q;
        cin >> p >> q;
        input.push_back(make_pair(p, q));
    }

    cin >> C;

    int result = 1;
    int priority = 0;

    while(true){

        if (find(input, priority) > 0) {    // 우선순위가 더 높은 사람이 있는 경우 큐의 뒤로 미룬다
            pair<int, int> tmp = input[0];
            input.erase(input.begin());
            input.push_back(tmp);
        }
        else if(find(input, priority) == -1){   // 해당되는 우선순위의 사람이 없을 경우 우선순위 증가
            priority++;
        }
        else {  // 해당 우선순위이면 큐에서 제거
            if(input[0].first == C && input[0].second <= priority){ // 해당 우선순위이면서 'C'이면 반복문 탈출
                break;
            }
            input.erase(input.begin());
            result++;
        }
    }

    cout << result;

    return 0;
}