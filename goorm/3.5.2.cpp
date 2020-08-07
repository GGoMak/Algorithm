#include <iostream>
#include <vector>
#include <cmath>

/*
 * 비타알고 2020년 3월 5주차 2번 : 후회(난이도 4)
 * 세그먼트 트리
*/

using namespace std;

int N, M;
vector<long long> v;
vector<long long> tree;

void init(int node, int s, int e){
    if(s == e){
        tree[node] = v[s];
        return;
    }

    init(node * 2, s, (s + e) / 2);
    init(node * 2 + 1, (s + e) / 2 + 1, e);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

long long query(int node, int s, int e, long long i, long long j){

    if(e < i || s > j){
        return 0;
    }

    if(s >= i && e <= j){
        return tree[node];
    }

    return query(node * 2, s, (s + e) / 2, i, j) + query(node * 2 + 1, (s + e) / 2 + 1, e, i, j);

}

void update(int node, int s, int e, long long i, long long num){

    if(i < s || i > e){
        return;
    }

    tree[node] += num;

    if(s != e) {
        update(node * 2, s, (s + e) / 2, i, num);
        update(node * 2 + 1, (s + e) / 2 + 1, e, i, num);
    }
}

int main(void){

    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> M;

    int log = ceil(log2(N));
    int size = (1 << (log + 1));
    tree.resize(size);
    v.resize(N + 1);

    for(int i = 1; i <= N; i++){
        cin >> v[i];
    }

    init(1, 1, N);

    for(int i = 0; i < M; i++){
        long long oper, a, b;

        cin >> oper >> a >> b;

        if(oper == 1){
            cout << query(1, 1, N, a, b) << endl;
        }
        else{
            update(1, 1, N, a, -b);
        }
    }

    return 0;
}