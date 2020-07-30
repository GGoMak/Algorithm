#include <iostream>
#include <vector>
#include <cmath>
/*
 * 비타알고 2020년 2월 1주차 1번 : 구간 합 구하기(난이도 3)
 * 세그먼트 트리
 *
 * 본 문제는 누적 합을 이용하여 풀이하는 문제이지만 일반적인 방법으로는 N * M의 시간 복잡도를 가짐
 * 하지만 특정 구간의 합을 구하거나, 특정 위치의 원소를 변경할 때 세그먼트 트리를 사용하면 log (N * M)의 시간 복잡도를 가짐
 */

using namespace std;

int N, M;
vector<long long> v;
vector<long long> tree;

void init(int node, int start, int end){    // 트리 초기값 세팅
    if(start == end){
        tree[node] = v[start];
        return;
    }

    init(node * 2, start, (start + end) / 2);
    init(node * 2 + 1, (start + end) / 2 + 1, end);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

long long query(int node, int start, int end, int i, int j){    // 구간의 합 구하기

    if(end < i || start > j){
        return 0;
    }

    else if(start >= i && end <= j){
        return tree[node];
    }

    return query(node * 2, start, (start + end) / 2, i, j) + query(node * 2 + 1, (start + end) / 2 + 1, end, i, j);
}

void update(int node, int start, int end, int i, long long num){    // 값 변경

    if(i < start || i > end){
        return;
    }

    tree[node] += num;

    if(start != end) {
        update(node * 2, start, (start + end) / 2, i, num);
        update(node * 2 + 1, (start + end) / 2 + 1, end, i, num);
    }
}

int main(void){

    cin >> N >> M;

    v.resize(N + 1);
    int log = ceil(log2(N));
    int size = pow(2, (log + 1));
    tree.resize(size);

    for(int i = 1; i <= N; i++){
        cin >> v[i];
    }

    init(1, 1, N);

    for(int i = 0; i < M; i++){
        long long oper, p, q;
        cin >> oper >> p >> q;

        if(oper == 1){  // 1 연산이 들어올 경우
            cout << query(1, 1, N, p, q) << endl;
        }
        else{           // 2 연산이 들어올 경우
            long long num = (q - v[p]);
            v[p] = q;
            update(1, 1, N, p, num);
        }
    }

    return 0;
}