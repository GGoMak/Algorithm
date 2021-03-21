package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자_G4 {

	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		
		for(int i = 0; i <= N; i++) {
			parents[i] = i;
		}
		
		boolean[][] map = new boolean[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num == 1) {
					map[i][j] = true;
				}
			}
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j < i; j++) {
				if(map[i][j]) {
					union(i, j);
				}
			}
		}
		
		boolean check = true;
		st = new StringTokenizer(br.readLine());
		int num = find(Integer.parseInt(st.nextToken()));
		
		for(int i = 1; i < M; i++) {
			int compareNum = find(Integer.parseInt(st.nextToken()));
			
			if(num != compareNum) {
				check = false;
				break;
			}
		}
		 
		if(check) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}
	
	public static int find(int x) {
		if(parents[x] == x) {
			return x;
		} else {
			return parents[x] = find(parents[x]);
		}
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			parents[y] = x;
		}
	}

}
