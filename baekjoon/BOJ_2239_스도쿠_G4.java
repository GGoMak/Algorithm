package Baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239_스도쿠_G4 {

    static int[][] map;
    static List<Point> pointList;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        pointList = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            String input = br.readLine();
            for(int j = 0; j < 9; j++) {
                map[i][j] = input.charAt(j) - '0';

                if(map[i][j] == 0) {
                    pointList.add(new Point(i, j));
                    count++;
                }
            }
        }

        dfs(0);
    }

    public static void dfs(int cnt) {

        if(cnt == count) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        int x = pointList.get(cnt).x;
        int y = pointList.get(cnt).y;

        for(int i = 1; i <= 9; i++) {
            if(isPossible(x, y, i)) {
                map[x][y] = i;
                dfs(cnt + 1);
                map[x][y] = 0;
            }
        }
    }

    public static boolean isPossible(int x, int y, int num) {

        for(int i = 0; i < 9; i++) {
            if(map[i][y] == num) {
                return false;
            } else if(map[x][i] == num) {
                return false;
            }
        }

        int tx = (x / 3) * 3;
        int ty = (y / 3) * 3;

        for(int i = tx; i < tx + 3; i++) {
            for(int j = ty; j < ty + 3; j++) {
                if(map[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}

