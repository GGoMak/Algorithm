package Baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class BOJ_4179_불_G4 {

    static int R, C;
    static char[][] map;
    static int startX, startY;
    static int result = Integer.MAX_VALUE;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        int x, y, cnt;
        char ch;
        Node(int x, int y, int cnt, char ch) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.ch = ch;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        List<Node> fire = new ArrayList<>();
        boolean[][] visit = new boolean[R][C];
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);

                if(map[i][j] == 'J') {
                    startX = i;
                    startY = j;
                    visit[startX][startY] = true;
                } else if(map[i][j] == 'F') {
                    q.add(new Node(i, j, 0, 'F'));
                    visit[i][j] = true;
                }
            }
        }

        q.add(new Node(startX, startY, 0, 'J'));

        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int cnt = q.peek().cnt;
            char ch = q.peek().ch;
            q.poll();

            if(x == 0 || y == 0 || x == R - 1 || y == C - 1) {
                if(ch == 'J') {
                    result = cnt;
                    break;
                }
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }

                if(!visit[nx][ny] && map[nx][ny] != '#') {
                    q.add(new Node(nx, ny, cnt + 1, ch));
                    visit[nx][ny] = true;
                }
            }
        }

        if(result == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result + 1);
        }

    }
	
}
