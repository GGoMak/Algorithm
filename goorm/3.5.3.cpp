#include <iostream>
#include <vector>
#include <cmath>
#include <climits>
/*
 * 비타알고 2020년 3월 5주차 3번 : 후회2(난이도 5)
 * 세그먼트 트리
 *
 * 합을 관리하는 트리와 최댓값을 관리하는 트리를 구현하고 최대값을 관리하는 트리는 pair를 이용해 인덱스값과 최대값을 동시에 관리한다.
*/

using namespace std;

int N, M;
vector<long long> v;
vector<long long> tree1;
vector<pair<int, long long>> tree2;

void init(int node, int s, int e){
    if(s == e){
        tree1[node] = v[s];
        tree2[node] = {s, v[s]};
        return;
    }

    init(node * 2, s, (s + e) / 2);
    init(node * 2 + 1, (s + e) / 2 + 1, e);
    tree1[node] = tree1[node * 2] + tree1[node * 2 + 1];

    if(tree2[node * 2].second < tree2[node * 2 + 1].second){
        tree2[node] = tree2[node * 2 + 1];
    }
    else{
        tree2[node] = tree2[node * 2];
    }
}

long long query1(int node, int s, int e, long long i, long long j){ // 합 구하기

    if(e < i || s > j){
        return 0;
    }

    if(s >= i && e <= j){
        return tree1[node];
    }

    return query1(node * 2, s, (s + e) / 2, i, j) + query1(node * 2 + 1, (s + e) / 2 + 1, e, i, j);

}

pair<int, long long> query2(int node, int s, int e, long long i, long long j){  // 최대값 구하기

    if(e < i || s > j){
        return {-1, -LONG_MAX};
    }

    if(i <= s && e <= j){
        return tree2[node];
    }

    auto res1 = query2(node * 2, s, (s + e) / 2, i, j);
    auto res2 = query2(node * 2 + 1, (s + e) / 2 + 1, e, i, j);

    if(res1.first == -1){
        return res2;
    }
    else if(res2.first == -1){
        return res1;
    }
    else{
        if(res1.second < res2.second){
            return res2;
        }
        else{
            return res1;
        }
    }
}

void update1(int node, int s, int e, int i, long long num){ // 합 트리 업데이트

    if(e < i || s > i){
        return;
    }

    tree1[node] += num;

    if(s != e) {
        update1(node * 2, s, (s + e) / 2, i, num);
        update1(node * 2 + 1, (s + e) / 2 + 1, e, i, num);
    }
}

void update2(int node, int s, int e, int i, long long num){ // 최대값 트리 업데이트
    if(e < i || s > i){
        return;
    }

    if(s == e){
        tree2[node] = {i, num};
        return;
    }

    update2(node * 2, s, (s + e) / 2, i, num);
    update2(node * 2 + 1, (s + e) / 2 + 1, e, i, num);

    if(tree2[node * 2].second < tree2[node * 2 + 1].second){
        tree2[node] = tree2[node * 2 + 1];
    }
    else{
        tree2[node] = tree2[node * 2];
    }
}

int main(void){

    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> M;

    int log = ceil(log2(N));
    int size = (1 << (log + 1));
    tree1.resize(size);
    tree2.resize(size);
    v.resize(N + 1);

    for(int i = 1; i <= N; i++){
        cin >> v[i];
    }

    init(1, 1, N);

    for(int i = 0; i < M; i++){
        long long oper, a, b;

        cin >> oper >> a >> b;

        if(oper == 1){
            cout << query1(1, 1, N, a, b) << endl;
        }
        else{
            int index = query2(1, 1, N, a, b).first;
            long long num = v[index] / 2;
            num = num - v[index];
            v[index] /= 2;
            update1(1, 1, N, index, num);
            update2(1, 1, N, index, v[index]);
        }
    }

    return 0;
}