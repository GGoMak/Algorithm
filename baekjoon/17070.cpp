#include <iostream>
#include <queue>

/*
 * 백준 17070번 : 파이프 옮기기 1(49%)
 * 완전탐색(BFS)
 */

using namespace std;
int N;
int map[17][17];

typedef struct Node{
    int x, y, dir;
}Node;

int bfs(int x, int y){

    queue<Node> q;
    q.push({0, 1, 0});
    int count = 0;

    while(!q.empty()){
        int x = q.front().x;
        int y = q.front().y;
        int dir = q.front().dir;
        q.pop();

        if(x == N - 1 && y == N - 1){
            count++;
        }

        if(dir == 0){   // 가로
            if(map[x][y + 1] == 0 && y + 1 < N){
                q.push({x, y + 1, 0});
                if(map[x + 1][y] == 0 && map[x + 1][y + 1] == 0 && x + 1 < N){
                    q.push({x + 1, y + 1, 2});
                }
            }
        }
        else if(dir == 1){  // 세로
            if(map[x + 1][y] == 0 && x + 1 < N){
                q.push({x + 1, y, 1});
                if(map[x][y + 1] == 0 && map[x + 1][y + 1] == 0 && y + 1 < N){
                    q.push({x + 1, y + 1, 2});
                }
            }
        }
        else{   // 대각선
            if(map[x][y + 1] == 0 && y + 1 < N){
                q.push({x, y + 1, 0});
            }
            if(map[x + 1][y] == 0 && x + 1 < N){
                q.push({x + 1, y, 1});
            }
            if(map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0 && x + 1 < N && y + 1 < N){
                q.push({x + 1, y + 1, 2});
            }
        }
    }

    return count;

}

int main(void){

    cin >> N;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> map[i][j];
        }
    }

    cout << bfs(1, 2);

    return 0;
}
