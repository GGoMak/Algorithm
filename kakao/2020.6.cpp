#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 2020 KAKAO BLIND RECRUITMENT : 외벽 점검(0.6%)
 * 구현
 *
 * next_permutaion을 이용하면 쉽게 순열을 구할 수 있음
*/

using namespace std;

int solution(int n, vector<int> weak, vector<int> dist) {
    int answer = 987654321;

    for(int i = 0; i < weak.size(); i++){

        vector<int> tdist;
        for(int j = 0; j < dist.size(); j++){
            tdist.push_back(dist[j]);
        }

        do{
            int distindex = 0, weakindex = 0;

            while(distindex <= tdist.size()) {
                int index = weak[weakindex] + tdist[distindex];

                for (int j = weakindex; j < weak.size(); j++) {
                    if (weak[j] > index) {
                        break;
                    }
                    weakindex++;
                }
                distindex++;

                if (weakindex >= weak.size()) {
                    answer = min(answer, distindex);
                    break;
                }
            }

        }while(next_permutation(tdist.begin(), tdist.end()));

        int tmp = weak[0] + n;
        weak.erase(weak.begin());
        weak.push_back(tmp);
    }

    if(answer > dist.size()){
        return -1;
    }

    return answer;
}

int main(void) {

    int N = 12;
    vector<int> weak, dist;

    for(int i = 0; i < 5; i++){
        int a;
        cin >> a;
        weak.push_back(a);
    }

    for(int i = 0; i < 3; i++){
        int a;
        cin >> a;
        dist.push_back(a);
    }

    cout << solution(N, weak, dist);

    return 0;
}