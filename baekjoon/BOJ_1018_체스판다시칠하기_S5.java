package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기_S5 {

	static int N, M;
	static char[][] map;
	
	static int solve(int x, int y) {
		
		int check = 0;
		int res1 = 0;
		
		// 왼쪽 위롤 W로 칠함
		for(int i = x; i < x + 8; i++) {
			for(int j = y; j < y + 8; j++) {
				// W로 칠해야 하는 칸이 이미 W면 넘어가기
				if((i + j) % 2 == 0 && map[i][j] == 'W') {
					continue;
				} 
				// B로 칠해야 하는 칸이 이미 B면 넘어가기
				else if((i + j) % 2 == 1 && map[i][j] == 'B') {
					continue;
				}
				// 칠하기
				res1++;
			}
		}
		
		int res2 = 0;
		
		// 왼쪽 위를 B로 칠함
		for(int i = x; i < x + 8; i++) {
			for(int j = y; j < y + 8; j++) {
				// B로 칠해야 하는 칸이 이미 B면 넘어가기
				if((i + j) % 2 == 0 && map[i][j] == 'B') {
					continue;
				} 
				// W로 칠해야 하는 칸이 이미 W면 넘어가기
				else if((i + j) % 2 == 1 && map[i][j] == 'W') {
					continue;
				}
				// 칠하기
				res2++;
			}
		}
		
		// 왼쪽 위가 W일때와 B일때 중 덜 칠하는 횟수 리턴
		return Math.min(res1, res2);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int min = 987654321;
		
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				int result = solve(i, j);
				
				if(min > result)
					min = result;
			}
		}
		
		System.out.println(min);
	}

}
