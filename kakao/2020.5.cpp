#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 2020 KAKAO BLIND RECRUITMENT : 기둥과 보 설치(1.7%)
 * 구현
*/

using namespace std;
int col[102][102], row[102][102];

bool checkCol(int x, int y, int n){

    if(y == 0){ // 땅일 경우
        return true;
    }

    else if(col[x][y - 1] == 1){ // 밑이 기둥일 경우
        return true;
    }

    else if(row[x - 1][y] == 1 && x - 1 >= 0){    // 기둥 밑이 보일경우(왼쪽으로)
        return true;
    }

    else if(row[x][y] == 1 && x + 1 <= n){    // 기둥 밑이 보일 경우(오른쪽으로)
        return true;
    }

    return false;
}

bool checkRow(int x, int y, int n){

    if(col[x][y - 1] == 1){    // 왼쪽이 기둥일 경우
        return true;
    }

    else if(col[x + 1][y - 1] == 1 && x + 1 <= n){    // 오른쪽이 기둥일 경우
        return true;
    }

    else if(row[x - 1][y] && row[x + 1][y] && x - 1 >= 0 && x + 1 <= n){ // 양쪽이 보일 경우
        return true;
    }

    return false;
}

vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
    vector<vector<int>> answer;
    int build_count = build_frame.size();

    for(int i = 0; i < build_count; i++){
        int x = build_frame[i][0];
        int y = build_frame[i][1];
        int a = build_frame[i][2];
        int b = build_frame[i][3];

        if(a == 0 && b == 1){
            if(checkCol(x, y, n)){
                col[x][y] = 1;
            }
        }
        else if(a == 1 && b == 1){
            if(checkRow(x, y, n)){
                row[x][y] = 1;
            }
        }
        else if(a == 0 && b == 0){
            bool check = true;
            col[x][y] = 0;

            if(col[x][y + 1] == 1 && !checkCol(x, y + 1, n) && y + 1 <= n){    // 위에 기둥이 있을 경우
                check = false;
            }
            else if(row[x][y + 1] == 1 && !checkRow(x, y + 1, n) && y + 1 <= n){  // 기둥 오른쪽으로 보가 있을 경우
                check = false;
            }
            else if(row[x - 1][y + 1] && !checkRow(x - 1, y + 1, n) && x - 1 >= 0 && y <= n){ // 기둥 왼쪽으로 보가 있을 경우
                check = false;
            }

            if(!check){
                col[x][y] = 1;
            }

        }
        else if(a == 1 && b == 0){
            bool check = true;
            row[x][y] = 0;

            if(row[x - 1][y] && !checkRow(x - 1, y, n) && x - 1 >= 0){  // 왼쪽에 보가 있는 경우
                check = false;
            }
            else if(row[x + 1][y] && !checkRow(x + 1, y, n) && x + 1 <= n){    // 오른쪽에 보가 있는 경우
                check = false;
            }
            else if(col[x][y] && !checkCol(x, y, n)){   // 왼쪽 위로 기둥이 있는 경우
                check = false;
            }
            else if(col[x + 1][y] && !checkCol(x + 1, y, n) && x + 1 <= n){   // 오른쪽 위로 기둥이 있는 경우
                check = false;
            }

            if(!check){
                row[x][y] = 1;
            }
        }

    }

    for(int i = 0; i <= n; i++){
        for(int j = 0; j <= n; j++){
            if(col[i][j] == 1){
                answer.push_back({i, j, 0});
            }
            if(row[i][j] == 1){
                answer.push_back({i, j, 1});
            }
        }
    }

    return answer;
}

int main(void) {

    int N;
    vector<vector<int>> build_frame;

    cin >> N;

    for(int i = 0; i < N; i++){
        vector<int> t;
        int x, y, a, b;
        cin >> x >> y >> a >> b;
        t.push_back(x);
        t.push_back(y);
        t.push_back(a);
        t.push_back(b);
        build_frame.push_back(t);
    }

    vector<vector<int>> res = solution(5, build_frame);

    for(int i = 0; i < res.size(); i++){
        for(int j = 0; j < 3; j++){
            cout << res[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}