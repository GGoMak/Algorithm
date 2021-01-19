#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

/*
 * 백준 19238번 : 스타트 택시(18%)
 *
 * BFS
 */

typedef struct Node {
    int startX, startY;
    int desX, desY;
}Node;

typedef struct Node2 {
    int x, y, cnt;
}Node2;

typedef struct Node3 {
    int n, x, y, cnt;
}Node3;

using namespace std;
int N, M, F;
int arr[402][402];
pair<int, int> taxi;
vector<Node> passenger;
int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };
int minDist;

bool compare(Node3 a, Node3 b){
    if(a.x < b.x){
        return true;
    } else if(a.x == b.x){
        if(a.y < b.y){
            return true;
        }
    }
    return false;
}

vector<Node3> findPassenger(int x, int y){
    int visit[402][402] = { 0 };
    queue<Node2> q;
    q.push({x, y, 0});
    visit[x][y] = 1;
    vector<Node3> res;
    int check = 0;

    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        int cnt = q.front().cnt;
        q.pop();

        if(cnt > F) {
            break;
        }

        if(cnt > minDist){
            break;
        }

        if(arr[x][y] > 1){
            minDist = cnt;
            res.push_back({arr[x][y] - 2, x, y});
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <= 0 || ny <= 0 || nx > N || ny > N){
                continue;
            }

            if(!visit[nx][ny] && arr[nx][ny] != 1){
                q.push({nx, ny, cnt + 1});
                visit[nx][ny] = 1;
            }
        }
    }

    return res;
}

int moveTaxi(int startX, int startY, int desX, int desY){

    int visit[402][402] = { 0 };
    queue<Node2> q;
    q.push({startX, startY, 0});
    visit[startX][startY] = 1;

    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        int cnt = q.front().cnt;
        q.pop();

        if(cnt > F){
            break;
        }

        if(x == desX && y == desY){
            return cnt;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <= 0 || ny <= 0 || nx > N || ny > N){
                continue;
            }

            if(!visit[nx][ny] && arr[nx][ny] != 1){
                q.push({nx, ny, cnt + 1});
                visit[nx][ny] = 1;
            }
        }
    }

    return -1;
}

int main(void){

    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M >> F;

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            cin >> arr[i][j];
        }
    }

    cin >> taxi.first >> taxi.second;

    int num = 2;
    for(int i = 0; i < M; i++){
        int x1, x2, y1, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        passenger.push_back({x1, y1, x2, y2});
        arr[x1][y1] = num++;
    }

    int i;

    for(i = 0; i < passenger.size(); i++){

        int passengerIndex = 0;
        minDist = 987654321;

        vector<Node3> list = findPassenger(taxi.first, taxi.second);

        if(list.size() == 0){
            cout << -1;
            return 0;
        }

        if(list.size() > 1) {
            sort(list.begin(), list.end(), compare);
        }
        passengerIndex = list[0].n;

        F -= minDist;

        // 승객 태우고 이동
        int cnt = moveTaxi(passenger[passengerIndex].startX, passenger[passengerIndex].startY, passenger[passengerIndex].desX, passenger[passengerIndex].desY);

        if(cnt < 0){    // 도착지에 못 갈 경우
            cout << -1;
            return 0;
        }

        F -= cnt;
        F += (cnt * 2);
        arr[passenger[passengerIndex].startX][passenger[passengerIndex].startY] = 0;
        taxi.first = passenger[passengerIndex].desX;
        taxi.second = passenger[passengerIndex].desY;
    }

    cout << F;

    return 0;
}