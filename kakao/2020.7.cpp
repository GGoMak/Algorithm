#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

/*
 * 2020 KAKAO BLIND RECRUITMENT : 블록 이동하기(1.4%)
 * BFS
*/

using namespace std;
int visit[101][101][2];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

typedef struct Node{
    int x1, y1;
    int position;
    int cnt;
}Node;

int solution(vector<vector<int>> board) {
    int answer = 987654321;
    int N = board.size();

    queue<Node> q;
    q.push({0, 0, 0, 0});
    visit[0][0][0] = 1;

    while(!q.empty()){
        int x1 = q.front().x1, y1 = q.front().y1;
        int position = q.front().position;
        int x2, y2;
        if(position == 0){
            x2 = x1;
            y2 = y1 + 1;
        }
        else{
            x2 = x1 + 1;
            y2 = y1;
        }
        int cnt = q.front().cnt;
        q.pop();

        if((x1 == N - 1 && y1 == N - 1) || (x2 == N - 1 && y2 == N - 1)){
            answer = min(answer, cnt);
            continue;
        }

        for(int i = 0; i < 4; i++) {
            int nx1 = x1 + dx[i], ny1 = y1 + dy[i];
            int nx2 = x2 + dx[i], ny2 = y2 + dy[i];

            if (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= N || nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= N) {
                continue;
            }

            if (board[nx1][ny1] == 0 && board[nx2][ny2] == 0 && visit[nx1][ny1][position] == 0) {
                visit[nx1][ny1][position] = 1;
                q.push({nx1, ny1, position, cnt + 1});
            }
        }

        if(position == 0){
            if(x1 + 1 < N && y1 + 1 < N && board[x1 + 1][y1 + 1] == 0 && board[x1 + 1][y1] == 0){
                if(visit[x1][y1][1] == 0) {
                    visit[x1][y1][1] = 1;
                    q.push({x1, y1, 1, cnt + 1});
                }
                if(visit[x1][y1 + 1][1] == 0) {
                    q.push({x1, y1 + 1, 1, cnt + 1});
                    visit[x1][y1 + 1][1] = 1;
                }
            }
            if(x1 - 1 >= 0 && y1 + 1 < N && board[x1 - 1][y1] == 0 && board[x1 - 1][y1 + 1] == 0){
                if(visit[x1 - 1][y1][1] == 0){
                    q.push({x1 - 1, y1, 1, cnt + 1});
                    visit[x1 - 1][y1][1] = 1;
                }
                if(visit[x1 - 1][y1 + 1][1] == 0) {
                    q.push({x1 - 1, y1 + 1, 1, cnt + 1});
                    visit[x1 - 1][y1 + 1][1] = 1;
                }
            }
        }
        else{
            if(y1 + 1 < N && x1 + 1 < N && board[x1][y1 + 1] == 0 && board[x1 + 1][y1 + 1] == 0){
                if(visit[x1][y1][0] == 0) {
                    q.push({x1, y1, 0, cnt + 1});
                    visit[x1][y1][0] = 1;
                }
                if(visit[x1 + 1][y1][0] == 0) {
                    q.push({x1 + 1, y1, 0, cnt + 1});
                    visit[x1 + 1][y1][0] = 1;
                }
            }
            if(y1 - 1 >= 0 && x1 + 1 < N && board[x1][y1 - 1] == 0 && board[x1 + 1][y1 - 1] == 0){
                if(visit[x1][y1 - 1][0] == 0) {
                    q.push({x1, y1 - 1, 0, cnt + 1});
                    visit[x1][y1 - 1][0] = 1;
                }
                if(visit[x1 + 1][y1 - 1][0] == 0) {
                    q.push({x1 + 1, y1 - 1, 0, cnt + 1});
                    visit[x1 + 1][y1 - 1][0] = 1;
                }
            }
        }
    }

    return answer;
}

int main(void) {

    int N;
    vector<vector<int>> board;
    cin >> N;
    for(int i = 0; i < N; i++){
        vector<int> t;
        for(int j = 0; j < N; j++){
            int a;
            cin >> a;
            t.push_back(a);
        }
        board.push_back(t);
    }

    cout << solution(board);

    return 0;
}