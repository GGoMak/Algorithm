package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현_G4 {

	static int N, M;
	static int[] parents;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int oper, a, b;
			
			oper = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(oper == 0) {
				union(a, b);
			} else {
				int x = find(a);
				int y = find(b);
				
				if(x == y) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		
		System.out.println(sb);
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
