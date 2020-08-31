#include <iostream>
#include <vector>
#include <climits>

/*
 * 백준 14889번 : 스타트와 링크(49%)
 * DFS
 *
 * 4명일때 1, 2 번 선수를 뽑나 2, 1 번 선수를 뽑나 같은 경우임, 이런 케이스를 연산에서 제외하지 않으면 시간초과 발생(49번쨰 줄)
 */

using namespace std;
int N;
int map[21][21];
int visit[21];
int result = INT_MAX;

void dfs(int k, int n){

    if(n == N / 2){
        vector<int> team_s, team_l;

        for(int i = 1; i <= N; i++){
            if(visit[i] == 1){
                team_s.push_back(i);
            }
            else{
                team_l.push_back(i);
            }
        }

        int start = 0, link = 0;

        for(int i = 0; i < N / 2; i++){
            for(int j = i + 1; j < N / 2; j++){
                start += map[team_s[i]][team_s[j]];
                start += map[team_s[j]][team_s[i]];
                link += map[team_l[i]][team_l[j]];
                link += map[team_l[j]][team_l[i]];
            }
        }

        result = min(result, abs(start - link));

        return;
    }


    for(int i = k + 1; i <= N; i++){
        if(visit[i] == 0){
            visit[i] = 1;
            dfs(i, n + 1);
            visit[i] = 0;
        }
    }
}

int main(void){

    cin >> N;

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            cin >> map[i][j];
        }
    }

    dfs(0, 0);

    cout << result;

    return 0;
}