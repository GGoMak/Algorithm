package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1_S3 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] selected;
	static boolean[] visit;
	
	public static void solve(int cnt) {
		
		if(cnt == M) {
			for(int i = 0; i < selected.length; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				selected[cnt] = i + 1;
				solve(cnt + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		selected = new int[M];
		visit = new boolean[N];
		
		solve(0);
		
		System.out.print(sb);
	}

}
