#include <iostream>
#include <queue>

/*
 * 백준 2206번 : 벽 부수고 이동하기(22%)
 * BFS
 *
 * 벽을 부수고 가는 좌표와 부수지 않고 가는 경우가 다르기 때문에 3차원 visit배열을 이용
 */

using namespace std;
char map[1010][1010];
int visit[1010][1010][2];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int N, M;

typedef struct Node{
    int x, y, w, cnt;
}Node;

int bfs(int x, int y){

    queue<Node> q;
    q.push({1, 1, 0, 1});
    visit[1][1][0] = 1;

    while(!q.empty()){
        int nx = q.front().x;
        int ny = q.front().y;
        int w = q.front().w;
        int cnt = q.front().cnt;
        q.pop();

        if(nx == N && ny == M){
            return cnt;
        }

        for(int i = 0; i < 4; i++){
            int nnx = nx + dx[i];
            int nny = ny + dy[i];

            if(nnx > 0 && nnx <= N && nny > 0 && nny <= M){
                if(map[nnx][nny] == '1' && w == 0){
                    q.push({nnx, nny, 1, cnt + 1});
                    visit[nnx][nny][1] = 1;
                }
                else if(map[nnx][nny] == '0' && visit[nnx][nny][w] == 0){
                    q.push({nnx, nny, w, cnt + 1});
                    visit[nnx][nny][w] = 1;
                }
            }
        }
    }

    return -1;
}

int main(void){

    cin >> N >> M;

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= M; j++){
            cin >> map[i][j];
        }
    }

    cout << bfs(1, 1);

    return 0;
}