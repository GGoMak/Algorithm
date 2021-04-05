package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집_G2 {

	static int R, C;
	static char[][] map;
	static int res;
	static int[] dx = {-1, 0, 1};
	static boolean[][] visit;
	static boolean[] check;
	
	
	public static void solve(int startRow, int cnt, int row) {
		
		if(row < 0 || row >= R) {
			return;
		}
		
		if(cnt == C - 1) {
			check[startRow] = true;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			int nx = row + dx[i];
			
			if(nx < 0 || nx >= R) {
				continue;
			}
			
			if(!visit[nx][cnt + 1] && map[nx][cnt + 1] == '.') {
				visit[nx][cnt + 1] = true;
				solve(startRow, cnt + 1, nx);
				
				if(check[startRow]) {
					break;
				} else {
					continue;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		check = new boolean[R];
		
		for(int i = 0; i < R; i++) {
			StringBuilder input = new StringBuilder(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++) {
			solve(i, 0, i);
		}
		
		for(int i = 0; i < R; i++) {
			if(check[i]) {
				res++;
			}
		}
		
		System.out.println(res);
	}

}
