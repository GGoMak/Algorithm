#include <iostream>
#include <vector>
#include <cmath>
/*
 * 비타알고 2020년 2월 1주차 2번 : 거의 최대 공약수(난이도 4)
 * 세그먼트 트리
 *
 * 1. 세그먼트 트리를 통해 구간별 최대공약수를 구해놓는다.
 * 2. i번째 수를 뺀 구간([1 ~ i - 1], [i + 1, N])의 최대값을 구하면 그것이 거의 최대공약수이다.
 * ex) 5개의 수열이 주어졌다면 ([2, 5]), ([1, 1], [3, 5]), ([1, 2], [4, 5]), ([1, 3], [5, 5]), ([1, 4])의 최대값을 찾으면 그것이 거의 최대공약수이다.
 *                         1을 뺌         2를 뺌             3을 뻄             4를 뺌          5를 뺌
 */

using namespace std;
int N;
vector<int> a;
vector<int> tree;

long long gcd(long long a, long long b){
    return b ? gcd(b, a % b) : a;
}

void init(int node, int start, int end){

    if(start == end){
        tree[node] = a[start];
        return;
    }

    init(node * 2, start, (start + end) / 2);
    init(node * 2 + 1, (start + end) / 2 + 1, end);
    tree[node] = gcd(tree[node * 2], tree[node * 2 + 1]);
}

long long query(int node, int start, int end, int i, int j){
    if(end < i || start > j){
        return 0;
    }

    if(i <= start && end <= j){
        return tree[node];
    }

    return gcd(query(node * 2, start, (start + end) / 2, i, j), query(node * 2 + 1, (start + end) / 2 + 1, end, i, j));
}

int main(void){

    cin >> N;
    a.resize(N + 1);
    int log = ceil(log2(N));
    int size = pow(2, log + 1);
    tree.resize(size);

    for(int i = 1; i <= N; i++){
        cin >> a[i];
    }

    init(1, 1, N);

    long long result = 0;

    for(int i = 1; i <= N; i++){
        result = max(result, gcd(query(1, 1, N, 1, i-1), query(1, 1, N, i + 1, N)));
    }

    cout << result;

    return 0;
}