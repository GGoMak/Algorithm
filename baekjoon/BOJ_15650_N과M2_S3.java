package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과M2_S3 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] selected;
	
	public static void solve(int cnt, int start) {
		
		if(cnt == M) {
			for(int i = 0; i < selected.length; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[cnt] = i + 1;
			solve(cnt + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		selected = new int[M];
		
		solve(0, 0);
		
		System.out.print(sb);
	}

}
