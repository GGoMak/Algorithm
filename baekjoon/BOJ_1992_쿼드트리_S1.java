package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리_S1 {

	static int N;
	static int[][] map;
	
	public static boolean compress(int x, int y, int size) {
		
		int check = map[x][y];
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(check != map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void solve(int x, int y, int size, StringBuilder str) {
		
		if(size == 1) {
			str.append(map[x][y]);
			return;
		}
		
		if(compress(x, y, size)) {
			str.append(map[x][y]);
			return;
		}
		
		str.append("(");
		
		size /= 2;
		
		solve(x, y, size, str);
		solve(x, y + size, size, str);
		solve(x + size, y, size, str);
		solve(x + size, y + size, size, str);
		
		str.append(")");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringBuilder st = new StringBuilder(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}
		
		StringBuilder res = new StringBuilder();
		
		solve(0, 0, N, res);
		
		System.out.println(res);
	}

}
