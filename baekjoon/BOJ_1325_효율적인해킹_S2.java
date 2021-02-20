package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1325_효율적인해킹_S2 {

	static int N, M;
	static ArrayList<Integer>[] node;
	static StringBuilder sb = new StringBuilder();
	static int max = 0;
	static int[] dp;
	static int cnt;
	
	public static void solve(int n, boolean[] visit) {
		
		for(int i = 0; i < node[n].size(); i++) {
			if(!visit[node[n].get(i)]) {
				visit[node[n].get(i)] = true;
				dp[node[n].get(i)]++;
				solve(node[n].get(i), visit);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		node = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			node[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a].add(b);
		}
		
		dp = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			if(!node[i].isEmpty()) {
				boolean[] visit = new boolean[N + 1];
				visit[i] = true;
				solve(i, visit);
			}
		}
		
		
		for(int i = 1; i <= N; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(dp[i] == max) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
		
	}

}
