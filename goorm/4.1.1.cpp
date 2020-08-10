#include <iostream>
#include <vector>

/*
 * 비타알고 2020년 4월 1주차 1번 : 선별진료소(난이도 3)
 * 이분탐색
*/

using namespace std;

int N, K;
vector<int> room;

int main(void){

    cin >> N >> K;

    for(int i = 0; i < K; i++){
        int num;
        cin >> num;
        room.push_back(num);
    }

    int l = 0, r = 1000000000;
    int result;

    while(r >= l){
        int mid = (r + l) / 2;
        long long totalNum = 0;
        for(int i = 0; i < K; i++){
            totalNum += (mid / room[i]);
        }

        if(totalNum >= N){
            r = mid - 1;
            result = mid;
        }
        else{
            l = mid + 1;
        }
    }

    cout << result;

    return 0;
}