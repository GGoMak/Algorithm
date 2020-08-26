#include <iostream>
#include <queue>
#include <algorithm>

/*
 * 백준 13460번 : 구슬 탈출2(25%)
 * BFS
 *
 * 구슬이 겹치는 경우를 생각하지 않고 구슬을 이동시킨 다음에 구슬이 겹칠 경우 그때 기존의 위치를 참고하여 구슬을 위치를 다시 지정해준다.
 */

using namespace std;
int N, M;
char map[11][11];
int visit[11][11][11][11];
pair<int, int> r, b, dest;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

typedef struct Node{
    int rx, ry;
    int bx, by;
    int cnt;
}Node;

void go(int& x, int& y, int dir){

    while(1){
        x = x + dx[dir];
        y = y + dy[dir];

        if(map[x][y] == '#'){
            x = x - dx[dir];
            y = y - dy[dir];
            break;
        }
        else if(map[x][y] == 'O'){
            break;
        }
    }
}

int bfs(){

    queue<Node> q;
    q.push({r.first, r.second, b.first, b.second, 0});
    visit[r.first][r.second][b.first][b.second] = 1;

    while(!q.empty()){
        int rnx = q.front().rx;
        int rny = q.front().ry;
        int bnx = q.front().bx;
        int bny = q.front().by;
        int cnt = q.front().cnt;
        q.pop();

        if(cnt > 10){   // 횟수가 10이 넘어가면 -1 리턴
            return -1;
        }

        if(rnx == dest.first && rny == dest.second){    // O에 도착하면 그때의 횟수 리턴
            return cnt;
        }

        for(int i = 0; i < 4; i++){ // 0 = 동, 1 = 서, 2 = 남, 3 = 북
            int rnnx = rnx, rnny = rny;
            int bnnx = bnx, bnny = bny;

            go(rnnx, rnny, i);  // 빨간 구슬 i방향으로 이동
            go(bnnx, bnny, i);  // 파란 구슬 i방향으로 이동

            if(bnnx == dest.first && bnny == dest.second){ // 파란 구슬이 홈에 들어가면 큐에 삽입 하지 않음
                continue;
            }

            if(rnnx == bnnx && rnny == bnny){   // 구슬이 겹치면 기존의 위치를 참고하여 안겹치게 한칸 이동시킴
                if(i == 0){
                    rny < bny ? rnny-- : bnny--;
                }
                else if(i == 1){
                    rny < bny ? bnny++ : rnny++;
                }
                else if(i == 2){
                    rnx < bnx ? rnnx-- : bnnx--;
                }
                else{
                    rnx < bnx ? bnnx++ : rnnx++;
                }
            }

            if(visit[rnnx][rnny][bnnx][bnny] == 0){
                q.push({rnnx, rnny, bnnx, bnny, cnt + 1});
                visit[rnnx][rnny][bnnx][bnny] = 1;
            }
        }
    }

    return -1;
}

int main(void){

    cin >> N >> M;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            char input;
            cin >> input;

            if(input == 'R')
                r = make_pair(i, j);
            else if(input == 'B')
                b = make_pair(i, j);
            else if(input == 'O')
                dest = make_pair(i, j);

            map[i][j] = input;
        }
    }

    cout << bfs();

    return 0;
}