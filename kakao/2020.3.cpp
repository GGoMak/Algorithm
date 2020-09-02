#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 2020 KAKAO BLIND RECRUITMENT : 자물쇠와 열쇠(7.4%)
 * 구현
 *
 * zero padding을 이용하여 검색
*/

using namespace std;

vector<vector<int>> rotate(vector<vector<int>> key, int n){

    vector<vector<int>> tmp;


    for(int i = 0; i < n; i++){
        vector<int> k;
        for(int j = 0; j < n; j++){
            k.push_back(key[i][j]);
        }
        tmp.push_back(k);
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            tmp[j][n - 1 - i] = key[i][j];
        }
    }

    return tmp;
}

bool unlock(vector<vector<int>> key, vector<vector<int>> lock, int x, int y){

    int N = lock.size();
    int M = key.size();

    vector<vector<int>> tmp;

    for(int i = 0; i < N; i++){
        vector<int> t;
        for(int j = 0; j < N; j++){
            t.push_back(lock[i][j]);
        }
        tmp.push_back(t);
    }

    for(int i = x; i < x + M; i++){
        for(int j = y; j < y + M; j++){
            if(i >= M - 1 && i <= N - M && j >= M - 1 && j <= N - M){
                tmp[i][j] += key[i - x][j - y];
            }
        }
    }

    for(int i = M - 1; i < N - M; i++){
        for(int j = M - 1; j < N - M; j++){
            if(tmp[i][j] != 1){
                return false;
            }
        }
    }

    return true;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock){

    int N = lock.size();
    int M = key.size();
    int check = 1;

    for(int i = 0; i < 4; i++){
        key = rotate(key, M);
        vector<vector<int>> lock_padding;

        for(int i = (-1) * M + 1; i < N + M; i++){
            vector<int> tmp;
            for(int j = (-1) * M + 1; j < N + M; j++){
                if(i < 0 || i >= N){
                    tmp.push_back(0);
                }
                else if(j < 0 || j >= N){
                    tmp.push_back(0);
                }
                else{
                    tmp.push_back(lock[i][j]);
                }
            }
            lock_padding.push_back(tmp);
        }

        for(int i = 0; i < N + M; i++) {
            for (int j = 0; j < N + M; j++) {
                check = unlock(key, lock_padding, i, j);
                if(check){
                    return true;
                }
            }
        }
    }

    return false;
}

int main(void) {

    vector<vector<int>> key;
    vector<vector<int>> lock;
    int N, M;

    cin >> N >> M;

    for(int i = 0; i < M; i++){
        vector<int> A;
        for(int j = 0; j < M; j++){
            int a;
            cin >> a;
            A.push_back(a);
        }
        key.push_back(A);
    }

    for(int i = 0; i < N; i++){
        vector<int> B;
        for(int j = 0; j < N; j++){
            int b;
            cin >> b;
            B.push_back(b);
        }
        lock.push_back(B);
    }

    bool check = solution(key, lock);

    if(check){
        cout << "true";
    }
    else{
        cout << "false";
    }

    return 0;
}