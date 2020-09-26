#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 백준 15685번 : 드래곤 커브(51%)
 * 구현
 */

using namespace std;
int N;
int map[101][101];

long long count(){
    long long res = 0;

    for(int i = 0; i < 100; i++){
        for(int j = 0; j < 100; j++){
            if(map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1){
                res++;
            }
        }
    }

    return res;
}

void draw(int x, int y, int d, int g){

    vector<pair<int, int>> v;

    if(d == 0){
        v.push_back(make_pair(1, 0));
    }
    else if(d == 1){
        v.push_back(make_pair(0, -1));
    }
    else if(d == 2){
        v.push_back(make_pair(-1, 0));
    }
    else if(d == 3){
        v.push_back(make_pair(0, 1));
    }

    map[y][x] = 1;
    x += v[0].first;
    y += v[0].second;
    map[y][x] = 1;

    for(int i = 1; i <= g; i++){
        for(int j = v.size() - 1; j >= 0; j--){
            if(v[j].first == 1 && v[j].second == 0){
                v.push_back(make_pair(0, -1));
            }
            else if(v[j].first == -1 && v[j].second == 0){
                v.push_back(make_pair(0, 1));
            }
            else if(v[j].first == 0 && v[j].second == 1){
                v.push_back(make_pair(1, 0));
            }
            else if(v[j].first == 0 && v[j].second == -1){
                v.push_back(make_pair(-1, 0));
            }
        }
    }

    for(int j = 1; j < v.size(); j++){
        x += v[j].first;
        y += v[j].second;

        map[y][x] = 1;
    }
}

int main(void){

    cin >> N;

    for(int i = 0; i < N; i++){
        int x, y, d, g;
        cin >> x >> y >> d >> g;

        draw(x, y, d, g);
    }

    cout << count();

    return 0;
}
