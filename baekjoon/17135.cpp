#include <iostream>
#include <queue>

/*
 * 백준 17135번 : 캐슬 디펜스(29%)
 * 구현 + 완전탐색
 */

using namespace std;
int N, M, D;
int map[17][17];
int res;

bool countEnemy(int tmpMap[17][17]){

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(tmpMap[i][j] == 1){
                return false;
            }
        }
    }
    return true;
}

int cal(){

    vector<int> archer;
    int result = 0;

    for(int i = 0; i < M; i++){ // 궁수 위치를 저장
        if(map[N][i] == 2){
            archer.push_back(i);
        }
    }

    int tmpMap[17][17] = {0};

    for(int i = 0; i < N; i++){ // tmpMap에 복사
        for(int j = 0; j < M; j++){
            tmpMap[i][j] = map[i][j];
        }
    }

    while(true) {
        vector<pair<int, int>> a;
        int ccheck = 0; // 타겟이 있는지 여부

        for (int k = 0; k < archer.size(); k++) {   // i번째 궁수와 가장 가까이 있는 적을 찾아냄
            int nx, ny, mini = 987654321;
            for (int y = 0; y < M; y++) {
                for (int x = N - 1; x >= 0; x--) {
                    if (tmpMap[x][y] == 1 && mini > abs(N - x) + abs(archer[k] - y) && abs(N - x) + abs(archer[k] - y) <= D) {
                        nx = x, ny = y;
                        mini = abs(N-x) + abs(archer[k] - y);
                        ccheck = 1;
                        break;
                    }
                }
            }
            int check = 1;  // 타겟이 중복되었는지 여부

            for (int i = 0; i < a.size(); i++) {    // 타겟이 중복되었는지 검사
                if (a[i].first == nx && a[i].second == ny) {
                    check = 0;
                    break;
                }
            }

            if (ccheck && check) {  // 타겟이 있고, 중복되지 않았으면 a벡터에 타겟을 삽입하고 죽인 적의 수 1 증가
                a.push_back(make_pair(nx, ny));
                result++;
            }
        }

        for (int i = 0; i < a.size(); i++) {    // 적을 죽임
            tmpMap[a[i].first][a[i].second] = 0;
        }

        for(int i = N - 1; i >= 0; i--){    // 적 전진
            for(int j = 0; j < M; j++){
                if(i == 0){
                    tmpMap[i][j] = 0;
                }
                else {
                    tmpMap[i][j] = tmpMap[i - 1][j];
                }
            }
        }

        if(countEnemy(tmpMap)){ // 남은 적의 수를 셈
            break;
        }
    }

    return result;
}

void dfs(int idx, int n){   // dfs로 궁수 배치

    if(n == 3){
        res = max(res, cal());
        return;
    }

    for(int i = idx; i < M; i++){
        map[N][i] = 2;
        dfs(i + 1, n + 1);
        map[N][i] = 0;
    }
}

int main(void){

    cin >> N >> M >> D;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> map[i][j];
        }
    }

    dfs(0, 0);

    cout << res;

    return 0;
}
