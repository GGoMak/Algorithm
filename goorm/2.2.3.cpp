#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>
/*
 * 비타알고 2020년 2월 2주차 3번 : 취약(난이도 3)
 * 세그먼트 트리
*/

using namespace std;
int N, M;
vector<int> a;
vector<int> tree;

void init(int node, int s, int e){
    if(s == e){
        tree[node] = a[s];
    }

    else{
        init(node * 2, s, (s + e) / 2);
        init(node * 2 + 1, (s + e) / 2 + 1, e);
        tree[node] = min(tree[node * 2],tree[node * 2 + 1]);
    }
}

int query(int node, int s, int e, int i, int j){
    if(j < s || i > e) {
        return INT_MAX;
    }
    if(i <= s && e <= j){
        return tree[node];
    }
    else{
        return min(query(node * 2, s, (s + e) / 2, i, j), query(node * 2 + 1, (s + e) / 2 + 1, e, i, j));
    }


}

int main(void){

    // cout, cin의 속도 개선
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> M;
    a.resize(N + 1);
    int log = ceil(log2(N));
    int size = pow(2, log + 1);
    tree.resize(size);

    for(int i = 1; i <= N; i++){
        cin >> a[i];
    }

    init(1, 1, N);

    for(int i = 0; i < M; i++){
        int p, q;
        cin >> p >> q;

        cout << query(1, 1, N, p, q) << endl;
    }
    return 0;
}