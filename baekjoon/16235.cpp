#include <iostream>
#include <queue>
#include <algorithm>

/*
 * 백준 16235번 : 나무 제테크(21%)
 * 구현
 */

typedef struct Node{
    int x, y, age;
}Node;

using namespace std;
int N, M, K;
vector<vector<vector<int>>> tree;
vector<Node> dead;
int food[51][51], A[51][51];
int dx[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dy[8] = {-1, 0, 1, -1, 1, -1, 0, 1};

bool compare(int a, int b){
    return a < b;
}

void spring(){

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            for(int k = 0; k < tree[i][j].size(); k++){
                if(food[i][j] - tree[i][j][k] >= 0){
                    food[i][j] -= tree[i][j][k];
                    tree[i][j][k]++;
                }
                else{
                    dead.push_back({i, j, tree[i][j][k]});
                    tree[i][j].erase(tree[i][j].begin() + k);
                    k--;
                }
            }
        }
    }
}

void summer(){

    for(int i = 0; i < dead.size(); i++){
        food[dead[i].x][dead[i].y] += (dead[i].age / 2);
    }
    dead.erase(dead.begin(), dead.end());
}

void fall(){

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            for(int k = 0; k < tree[i][j].size(); k++){
                if(tree[i][j][k] % 5 == 0){
                    for(int p = 0; p < 8; p++){
                        int nx = i + dx[p];
                        int ny = j + dy[p];

                        if(nx < 1 || nx > N || ny < 1 || ny > N){
                            continue;
                        }
                        tree[nx][ny].insert(tree[nx][ny].begin(), 1);
                    }
                }
            }
        }
    }
}

void winter(){

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            food[i][j] += A[i][j];
        }
    }
}

int main(void){

    cin >> N >> M >> K;

    tree.resize(N + 1);

    for(int i = 1; i <= N; i++){
        tree[i].resize(N + 1);
    }

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            cin >> A[i][j];
            food[i][j] = 5;
        }
    }

    for(int i = 0; i < M; i++){
        int x, y, z;
        cin >> x >> y >> z;
        tree[x][y].push_back(z);
    }

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            sort(tree[i][j].begin(), tree[i][j].end(), compare);
        }
    }

    for(int i = 0; i < K; i++){
        spring();
        summer();
        fall();
        winter();
    }

    int result = 0;

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            result += tree[i][j].size();
        }
    }

    cout << result;

    return 0;
}
