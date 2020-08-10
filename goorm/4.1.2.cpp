#include <iostream>
#include <vector>
#include <queue>

/*
 * 비타알고 2020년 4월 1주차 2번 : 물약제조(난이도 3)
 * BFS
 *
 * 총 6가지 연산에 대해 BFS를 진행하면 됨
 * 1. A병을 채움               2. B병을 채움
 * 3. A병을 버림               4. B병을 버림
 * 5. A병에서 B병으로 옮김       6. B병에서 A병으로 옮김
*/

using namespace std;

typedef struct Node{
    int a;
    int b;
}Node;

int A, B, C, D;
int check[1001][1001];

int main(void){

    cin >> A >> B >> C >> D;

    queue<Node> q;
    q.push({0, 0});

    check[0][0] = 1;

    while(!q.empty()){
        int a = q.front().a;
        int b = q.front().b;
        q.pop();

        if(a == C && b == D){
            break;
        }

        if(check[A][b] == 0){   // A병을 가득 채울 때
            check[A][b] = check[a][b] + 1;
            q.push({A, b});
        }
        if(check[a][B] == 0){   // B병을 가득 채울 때
            check[a][B] = check[a][b] + 1;
            q.push({a, B});
        }
        if(check[0][b] == 0){   // A병을 버릴 때
            check[0][b] = check[a][b] + 1;
            q.push({0, b});
        }
        if(check[a][0] == 0){   // B병을 버릴 때
            check[a][0] = check[a][b] + 1;
            q.push({a, 0});
        }

        Node tmp = {max(a - (B - b), 0), min(a + b, B)}; // A병 -> B병 이동
        if(check[tmp.a][tmp.b] == 0){
            check[tmp.a][tmp.b] = check[a][b] + 1;
            q.push({tmp.a, tmp.b});
        }
        tmp = {min(a + b, A), max(b - (A - a), 0)};     // B병 -> A 이동
        if(check[tmp.a][tmp.b] == 0){
            check[tmp.a][tmp.b] = check[a][b] + 1;
            q.push({tmp.a, tmp.b});
        }
    }

    if(check[C][D] == 0){
        cout << -1;
    }
    else {
        cout << check[C][D];
    }
    return 0;
}