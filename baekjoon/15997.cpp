#include <iostream>
#include <algorithm>

/*
 * 백준 15997번 : 승부 예측(28%)
 * DFS
 */

using namespace std;

typedef struct Node{
    int t1, t2;
    double w, d, l;
}Node;

string team[4];
Node node[6];
int vp[4];
pair<int, int> point[4];
double res[4];

void dfs(int n, double per){

    if(n == 6){
        for(int i = 0; i < 4; i++){
            point[i].first = vp[i];
            point[i].second = i;
        }
        sort(point, point + 4);

        int A = point[0].first, B = point[1].first, C = point[2].first, D = point[3].first;
        int a = point[0].second, b = point[1].second, c = point[2].second, d = point[3].second;

        if(A == B && B == C && C == D){     // 4팀이 동점인 경우
            res[a] += per / 2.0;
            res[b] += per / 2.0;
            res[c] += per / 2.0;
            res[d] += per / 2.0;
        }

        else if(A == B && B == C && C < D){ // 2, 3, 4등이 동점인 경우
            res[a] += per / 3.0;
            res[b] += per / 3.0;
            res[c] += per / 3.0;
            res[d] += per;
        }

        else if(A < B && B == C && C == D){ // 1, 2, 3등이 동점인 경우
            res[a] += per * 0.0;
            res[b] += per / (3.0/2.0);
            res[c] += per / (3.0/2.0);
            res[d] += per / (3.0/2.0);
        }

        else if(A < B && B == C && C < D){  // 2, 3등이 동점인 경우
            res[a] += per * 0.0;
            res[b] += per / 2.0;
            res[c] += per / 2.0;
            res[d] += per;
        }

        else{                               // 1, 2등을 가릴수 있는 경우
            res[a] += per * 0.0;
            res[b] += per * 0.0;
            res[c] += per;
            res[d] += per;
        }

        return;
    }

    int t1 = node[n].t1, t2 = node[n].t2;

    vp[t1] += 3;
    dfs(n + 1, per * node[n].w);
    vp[t1] -= 3;

    vp[t1] += 1;
    vp[t2] += 1;
    dfs(n + 1, per * node[n].d);
    vp[t1] -= 1;
    vp[t2] -= 1;

    vp[t2] += 3;
    dfs(n + 1, per * node[n].l);
    vp[t2] -= 3;

}

int main(void){

    cin >> team[0] >> team[1] >> team[2] >> team[3];

    for(int i = 0; i < 6; i++){
        string A, B;
        double w, d, l;

        cin >> A >> B >> w >> d >> l;

        for(int j = 0; j < 4; j++){
            if(A == team[j]){
                node[i].t1 = j;
            }
            else if(B == team[j]){
                node[i].t2 = j;
            }
        }

        node[i].w = w;
        node[i].d = d;
        node[i].l = l;
    }

    dfs(0, 1.0);

    for(int i = 0; i < 4; i++){
        cout << res[i] << endl;
    }

    return 0;
}