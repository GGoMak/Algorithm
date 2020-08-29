#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

/*
 * 백준 3190번 : 뱀(35%)
 * 구현
 */

using namespace std;
int N, K, L;
vector<pair<int, int>> apple;
vector<pair<int, char>> order;
vector<pair<int, int>> snake;
int curDir;

int move(int x, int y, int cnt){

    int n = 0;

    while(cnt--){
        int check = 0, nx, ny;

        if(curDir == 0){
            nx = snake[snake.size() - 1].first, ny = snake[snake.size() - 1].second + 1;

            for(int i = 0; i < snake.size(); i++){
                if(snake[i].first == nx && snake[i].second == ny){
                    return n;
                }
            }

            for(int i = 0; i < apple.size(); i++){
                if(apple[i].first == nx && apple[i].second == ny){
                    check = 1;
                    apple.erase(apple.begin() + i);
                }
            }

            snake.push_back(make_pair(nx, ny));

            if(!check){
                snake.erase(snake.begin());
            }
        }
        else if(curDir == 1){
            nx = snake[snake.size() - 1].first + 1, ny = snake[snake.size() - 1].second;

            for(int i = 0; i < snake.size(); i++){
                if(snake[i].first == nx && snake[i].second == ny){
                    return n;
                }
            }

            for(int i = 0; i < apple.size(); i++){
                if(apple[i].first == nx && apple[i].second == ny){
                    check = 1;
                    apple.erase(apple.begin() + i);
                }
            }

            snake.push_back(make_pair(nx, ny));

            if(!check){
                snake.erase(snake.begin());
            }
        }
        else if(curDir == 2){
            nx = snake[snake.size() - 1].first, ny = snake[snake.size() - 1].second - 1;

            for(int i = 0; i < snake.size(); i++){
                if(snake[i].first == nx && snake[i].second == ny){
                    return n;
                }
            }

            for(int i = 0; i < apple.size(); i++){
                if(apple[i].first == nx && apple[i].second == ny){
                    check = 1;
                    apple.erase(apple.begin() + i);
                }
            }

            snake.push_back(make_pair(nx, ny));

            if(!check){
                snake.erase(snake.begin());
            }
        }
        else{
            nx = snake[snake.size() - 1].first - 1, ny = snake[snake.size() - 1].second;

            for(int i = 0; i < snake.size(); i++){
                if(snake[i].first == nx && snake[i].second == ny){
                    return n;
                }
            }

            for(int i = 0; i < apple.size(); i++){
                if(apple[i].first == nx && apple[i].second == ny){
                    check = 1;
                    apple.erase(apple.begin() + i);
                }
            }

            snake.push_back(make_pair(nx, ny));

            if(!check){
                snake.erase(snake.begin());
            }
        }

        if(nx < 0 || nx >= N || ny < 0 || ny >= N){
            return n;
        }

        n++;
    }

    return n;
}

int dummy(int x, int y){

    int res = 0;

    int cnt = move(x, y, order[0].first);
    res += cnt;

    for(int i = 1; i < order.size(); i++){
        cnt = move(x, y, order[i].first - order[i-1].first);
        res += cnt;

        if(cnt != order[i].first - order[i-1].first){
            return res;
        }

        if(order[i].second == 'D'){
            curDir = curDir + 1 > 3 ? 0 : curDir + 1;
        }
        else{
            curDir = curDir - 1 < 0 ? 3 : curDir - 1;
        }
    }

    return res;
}

int main(void){

    cin >> N;
    cin >> K;

    for(int i = 0; i < K; i++){
        int a, b;
        cin >> a >> b;
        apple.push_back(make_pair(a - 1, b - 1));
    }

    cin >> L;
    order.push_back(make_pair(0, NULL));
    for(int i = 0; i < L; i++){
        int a; char b;
        cin >> a >> b;
        order.push_back(make_pair(a, b));
    }
    order.push_back(make_pair(INT_MAX, NULL));

    snake.push_back(make_pair(0, 0));

    cout << dummy(0, 0) + 1;

    return 0;
}