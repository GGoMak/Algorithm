#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 백준 15686번 : 치킨 배달(40%)
 * 구현
 *
 * 부분집합 구하기
 */

using namespace std;
int N, M;
int map[51][51];
vector<pair<int, int>> chicken;
vector<pair<int, int>> home;
vector<vector<pair<int, int>>> v;
int visit[14];
int result = 987654321;

void find(){

    for(int i = 0; i < v.size(); i++){
        int d = 0;

        for(int k = 0; k < home.size(); k++){
            int minD = 987654321;
            for(int j = 0; j < v[i].size(); j++){
                minD = min(minD, abs(v[i][j].first - home[k].first) + abs(v[i][j].second - home[k].second));
            }
            d += minD;
        }

        result = min(result, d);
    }

}

void combination(int index, vector<pair<int, int>> combi, int cnt, int num){

    if(cnt == num){
        v.push_back(combi);
        return;
    }

    for(int i = index; i < chicken.size(); i++){
        if(visit[i] == 0){
            combi.push_back(chicken[i]);
            visit[i] = 1;

            combination(i + 1, combi, cnt + 1, num);

            visit[i] = 0;
            combi.erase(combi.end() - 1);
        }
    }
}

int main(void){

    cin >> N >> M;

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            cin >> map[i][j];

            if(map[i][j] == 1){
                home.push_back(make_pair(i, j));
            }

            else if(map[i][j] == 2){
                chicken.push_back(make_pair(i, j));
            }
        }
    }
    vector<pair<int, int>> tmp;

    for(int i = 1; i <= M; i++) {
        combination(0, tmp, 0, i);
    }

    find();

    cout << result;

    return 0;
}
