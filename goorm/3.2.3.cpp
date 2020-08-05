#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

/*
 * 비타알고 2020년 3월 2주차 3번 : 미로찾기(난이도 4)
 * BFS
*/

using namespace std;

int N;
int map[1010][1010];
int check[1010][1010];
vector<pair<int, int>> warp[10];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};

typedef struct Node{
    int x;
    int y;
    int w;
}Node;

int main(){

    cin >> N;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++) {
            int num;
            cin >> num;
            map[i][j] = num;

            if(num > 1){
                warp[num].push_back(make_pair(i, j));
            }
        }
    }

    queue<Node> q;

    q.push({0, 0, 0});
    check[0][0] = 1;

    while(!q.empty()){
        int x = q.front().x;
        int y = q.front().y;
        int w = q.front().w;
        q.pop();

        if(x == N - 1 && y == N - 1){
            cout << check[x][y];
            return 0;
        }

        bool checkWarp = false;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            int num = map[x][y];

            if(!checkWarp && num > 1 && (w & (1 << num)) == 0){
                for(int j = 0; j < warp[num].size(); j++){
                    int nnx = warp[num][j].first;
                    int nny = warp[num][j].second;

                    if(check[nnx][nny] == 0){
                        check[nnx][nny] = check[x][y] + 1;
                        q.push({nnx, nny, (w | (1 << num))});
                    }
                }
                checkWarp = true;
            }

            if((num == 0 || (w & (1 << num))) && check[nx][ny] == 0 && nx >= 0 && ny >= 0 && nx < N && ny < N){
                check[nx][ny] = check[x][y] + 1;
                q.push({nx, ny, w});
            }
        }

    }

    cout << -1;

    return 0;
}