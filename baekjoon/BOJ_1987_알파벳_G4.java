package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳_G4 {

	static int R, C, max;
	static char[][] map;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static class Node{
		int x, y, cnt;
		Node(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void solve(int x, int y, int check, int cnt) {
		
		max = Math.max(cnt, max);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
				continue;
			}
			
			if((check & (1 << map[nx][ny] - 'A')) > 0) {
				continue;
			}
			
			solve(nx, ny, check | (1 << map[nx][ny] - 'A'), cnt + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			StringBuilder input = new StringBuilder(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		solve(0, 0, 1 << map[0][0] - 'A', 1);
		
		System.out.println(max);
	}

}
