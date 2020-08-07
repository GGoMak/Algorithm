#include <iostream>
#include <algorithm>
#include <queue>

/*
 * 비타알고 2020년 3월 4주차 3번 : 벽 통과하기(난이도 4)
 * BFS + 덱(deque)
 *
 * 덱(deque)를 이용하여 벽을 통해 움직이는 노드부터 계산할 수 있다. (시간 단축)
*/

using namespace std;

int N;
int map[1001][1001];
int chk[1001][1001];
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

typedef struct Node{
    int x;  // x 좌표
    int y;  // y 좌표
    int stat;   // 1이면 벽을 이동, 0이면 땅을 이동
}Node;

void bfs(){

    deque<Node> q;

    q.push_back({0, 0, 1});
    chk[0][0] = 0;

    while(!q.empty()){
        int x = q.front().x;
        int y = q.front().y;
        int stat = q.front().stat;
        q.pop_front();

        if(x == N - 1 && y == N - 1){
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N && (chk[x][y] + stat < chk[nx][ny])){

                if(map[nx][ny] == 0) {  // 갈 곳이 벽이 아니면 큐의 뒤에 삽입
                    q.push_back({nx, ny, 1});
                    chk[nx][ny] = min(chk[nx][ny], chk[x][y] + stat);
                }
                else if(map[nx][ny] == 1){  // 갈 곳이 벽이면 큐의 앞에 삽입
                    q.push_front({nx, ny, 0});
                    chk[nx][ny] = min(chk[nx][ny], chk[x][y] + stat);
                }
            }
        }
    }

}

int main(void){

    cin >> N;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> map[i][j];
            chk[i][j] = 1e9;
        }
    }

    bfs();

    cout << chk[N-1][N-1];

    return 0;
}