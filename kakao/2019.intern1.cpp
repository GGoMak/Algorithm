#include <iostream>
#include <vector>

/*
 * 2019 KAKAO 개발자 겨울 인턴쉽 : 크레인 인형뽑기 게임
 * 구현
*/

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    vector<int> basket;

    for(int i = 0; i < moves.size(); i++){
        int pos = moves[i] - 1;
        int j;

        for(j = 0; j < board.size(); j++){
            if(board[j][pos] != 0){
                basket.push_back(board[j][pos]);
                board[j][pos] = 0;
                break;
            }
        }

        if(basket.size() > 1 && basket[basket.size() - 1] == basket[basket.size() - 2]){
            basket.erase(basket.end() - 2, basket.end());
            answer += 2;
        }
    }

    return answer;
}

int main(void) {

    int n, m;
    cin >> n >> m;
    vector<vector<int>> board;

    for(int i = 0; i < n; i++){
        vector<int> t;
        for(int j = 0; j < n; j++){
            int a;
            cin >> a;
            t.push_back(a);
        }
        board.push_back(t);
    }

    vector<int> moves;
    for(int i = 0; i < m; i++){
        int a;
        cin >> a;
        moves.push_back(a);
    }

    cout << solution(board, moves);

    return 0;
}