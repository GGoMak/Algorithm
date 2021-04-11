package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16946_벽부수고이동하기4_G2 {

    static int N, M;
    static int[][] map;
    static int[][] result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = new int[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                char ch = input.charAt(j);
                if(ch == '1') {
                    map[i][j] = 1;
                    result[i][j] = 1;
                }
            }
        }

        boolean[][] visit = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();
        Queue<Point> wall = new LinkedList<>();
        
        for(int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                if (!visit[a][b] && map[a][b] == 0) {
                    q.add(new Point(a, b));
                    visit[a][b] = true;
                    int count = 0;

                    while (!q.isEmpty()) {
                        int x = q.peek().x;
                        int y = q.peek().y;
                        q.poll();
                        count++;

                        for (int i = 0; i < 4; i++) {
                            int nx = x + dx[i];
                            int ny = y + dy[i];

                            if (nx < 0 | ny < 0 || nx >= N || ny >= M) {
                                continue;
                            }

                            if (!visit[nx][ny] && map[nx][ny] == 0) {
                                visit[nx][ny] = true;
                                q.add(new Point(nx, ny));
                            } else if (!visit[nx][ny] && map[nx][ny] == 1) {
                                visit[nx][ny] = true;
                                wall.add(new Point(nx, ny));
                            }
                        }
                    }

                    while (!wall.isEmpty()) {
                        Point node = wall.poll();
                        result[node.x][node.y] += count;
                        visit[node.x][node.y] = false;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(result[i][j] % 10);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
