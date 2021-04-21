package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2665_미로만들기_G4 {
	
	static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        int x, y, cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        dp[0][0] = 0;

        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int cnt = q.peek().cnt;
            q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if(map[nx][ny] == 0 && dp[nx][ny] > cnt + 1) {
                    q.add(new Node(nx, ny, cnt + 1));
                    dp[nx][ny] = cnt + 1;
                } else if(map[nx][ny] == 1 && dp[nx][ny] > cnt) {
                    q.add(new Node(nx, ny, cnt));
                    dp[nx][ny] = cnt;
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
