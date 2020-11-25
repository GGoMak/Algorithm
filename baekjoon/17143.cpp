#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 백준 17143번 : 낚시왕(22%)
 * 구현
 */

using namespace std;

typedef struct Node{
    int r, c, s, d, z;
}Node;

int R, C, M, result;
vector<int> map[102][102];
vector<Node> shark;
int dx[5] = {0, -1, 1, 0, 0};
int dy[5] = {0, 0, 0, 1, -1};

bool compare(int x, int y){
    return shark[x].z > shark[y].z;
}

void eating(){

    for(int i = 1; i <= R; i++){
        for(int j = 1; j <= C; j++){
            if(map[i][j].size() > 1){
                sort(map[i][j].begin(), map[i][j].end(), compare);
                int n = map[i][j][0];

                for(int k = 1; k < map[i][j].size(); k++){
                    shark[map[i][j][k]].r = -1;
                    shark[map[i][j][k]].c = -1;
                    shark[map[i][j][k]].z = 0;
                }

                map[i][j].clear();
                map[i][j].push_back(n);
            }
        }
    }
}

void moving(){

    for(int i = 0; i < shark.size(); i++){
        if(shark[i].z != 0){
            map[shark[i].r][shark[i].c].clear();
        }
    }

    for(int i = 0; i < shark.size(); i++){
        int s = shark[i].s;
        int r = shark[i].r;
        int c = shark[i].c;
        int d = shark[i].d;

        if(shark[i].z == 0){
            continue;
        }

        if(d == 1 || d == 2){
            int ccnt = s % ((R - 1) * 2);

            for (int j = 0; j < ccnt; j++)
            {
                int nr = r + dx[d];
                int nc = c + dy[d];

                if (nr < 1) {
                    d = 2;
                    nr = nr + 2;
                }
                if (nr > R)
                {
                    d = 1;
                    nr = nr - 2;
                }
                r = nr;
                c = nc;
            }
        }

        else if(d == 3 || d == 4){
            int ccnt = s % ((C - 1) * 2);

            for (int j = 0; j < ccnt; j++)
            {
                int nr = r + dx[d];
                int nc = c + dy[d];

                if (nc < 1) {
                    d = 3;
                    nc = nc + 2;
                }
                if (nc > C)
                {
                    d = 4;
                    nc = nc - 2;
                }
                r = nr;
                c = nc;
            }
        }

        shark[i].r = r;
        shark[i].c = c;
        shark[i].d = d;
        map[r][c].push_back(i);
    }
}

void fishing(int index){

    for(int i = 1; i <= R; i++){
        if(map[i][index].size() != 0){
            result += shark[map[i][index][0]].z;
            shark[map[i][index][0]].z = 0;

            map[i][index].clear();
            break;
        }
    }
}

int main(void){

    cin >> R >> C >> M;

    for(int i = 0; i < M; i++){
        int r, c, s, d, z;
        cin >> r >> c >> s >> d >> z;

        shark.push_back({r, c, s, d, z});
        map[r][c].push_back(i);
    }

    for(int i = 1; i <= C; i++){
        fishing(i);
        moving();
        eating();
    }

    cout << result;
}