package Baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_3190_뱀_G5 {

    static int N, K, L;
    static int[][] map;
    static LinkedList<Node> order;
    static LinkedList<Point> snake;
    static int snakeDir = 0;
    static int time;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Node{
        int time;
        char dir;
        Node(int time, char dir){
            this.time = time;
            this.dir = dir;
        }
    }

    public static void solve(){

        while(true){

            if(order.size() > 0){
                if(order.get(0).time == time){
                    if(order.get(0).dir == 'D') {
                        snakeDir = (snakeDir + 1) % 4;
                    } else {
                        snakeDir = snakeDir - 1;
                        if(snakeDir < 0){
                            snakeDir = 3;
                        }
                    }
                    order.remove(0);
                }
            }

            time++;

            int nx = snake.get(snake.size() - 1).x + dx[snakeDir];
            int ny = snake.get(snake.size() - 1).y + dy[snakeDir];

            if(nx <= 0 || ny <= 0 || nx > N || ny > N){
                break;
            }

            if(map[nx][ny] == 1){
                break;
            }

            snake.add(new Point(nx, ny));

            if(map[nx][ny] ==  2){
                map[nx][ny] = 1;
            } else{
                map[nx][ny] = 1;
                map[snake.get(0).x][snake.get(0).y] = 0;
                snake.remove(0);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        snake = new LinkedList<>();

        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 2;
        }

        L = Integer.parseInt(br.readLine());
        order = new LinkedList<>();

        for(int i = 0; i < L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            order.add(new Node(time, dir));
        }

        map[1][1] = 1;
        snake.add(new Point(1, 1));
        solve();

        System.out.println(time);
    }
}
