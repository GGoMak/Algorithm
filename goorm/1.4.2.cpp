#include <iostream>
#include <vector>
#include <queue>
/*
 * 비타알고 2020년 1월 4주차 2번 : 게임 설치(난이도 3)
 * 그리디 알고리즘
 *
 * 우선순위 큐를 사용하며 풀이가 가능하며 최소값이 먼저 나와야 하기 때문에 인덱스값에 '-'를 붙인 값을 넣는게 핵심
 */

using namespace std;
int K, N;
vector<int> input;
vector<int> cdRom;
int checkCdRom[1001];

int find(vector<priority_queue<int>> q){

    int m = 0, res;

    for(int i = 0; i < K; i++){
        if(q[cdRom[i]].empty()){
            return i;
        }
        else if(-q[cdRom[i]].top() > m){
            m = -q[cdRom[i]].top();
            res = i;
        }
    }

    return res;
}

int main(){

    cin >> K >> N;
    vector<priority_queue<int>> queue(N + 1);   // 대기중인 cd 대기열
    int result = 0;
    int cur;

    for(int i = 0; i < N; i++){     // 우선 cd롬을 가득 채운다.
        int a;
        cin >> a;
        input.push_back(a);
        queue[input[i]].push(-i);   // 가장 먼저 사용되는 CD가 먼저 나와야 해서 i가 작은게 먼저 나오게 해야함

        if(checkCdRom[input[i]] == 0 && cdRom.size() < K){  // 같은 번호의 cd가 cd롬에 들어있지 않고 cd롬이 비어있을 경우
            checkCdRom[input[i]] = 1;                       // 해당 번호의 cd를 사용중으로 변경
            cdRom.push_back(input[i]);                      // cd롬에 넣음
            queue[input[i]].pop();                          // cd대기열에서 뺌
            cur = i;
        }
        else if(checkCdRom[input[i]] == 1 && cdRom.size() < K){ // 같은번호의 cd가 cd롬에 들어가 있는 경우
            queue[input[i]].pop();                          // cd대기열에서 뺌
        }
    }

    for(int i = cur + 1; i < N; i++){
        if(checkCdRom[input[i]] == 0){  // 같은 cd번호가 cd롬 안에 없으면
            int index = find(queue);    // 교체할 cd롬 번호를 선택

            checkCdRom[cdRom[index]] = 0;   // cd롬에서 빠진 cd를 사용하지 않음으로 변경
            cdRom[index] = input[i];    // cd롬에 cd를 넣음
            checkCdRom[input[i]] = 1;   // cd롬에 넣은 cd를 사용중으로 변경

            result++;   // 교체횟수 증가
        }
        queue[input[i]].pop();  // cd가 cd롬에 들어갔으므로 대기중인 cd대기열에서 뺌
    }

    cout << result;
    return 0;
}