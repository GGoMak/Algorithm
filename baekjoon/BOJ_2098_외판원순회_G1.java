package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2098_외판원순회_G1 {

	static int N;
	static int[][] map;
	static int[][] memo;
	static int INF = 987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		memo = new int[N][1 << N];
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		System.out.println(solve(0, 1));
	}
	
	public static int solve(int cur, int visited) {
		
		if(memo[cur][visited] != 0) {
			return memo[cur][visited];
		}
		
		if(visited == (1 << N) - 1) {
			if(map[cur][0] != 0) {
				return map[cur][0];
			} else {
				return INF;
			}
		}
		
		memo[cur][visited] = INF;
		
		for(int i = 0; i < N; i++) {
			// 미방문이고 연결되어 있다면
			if((visited & (1 << i)) == 0 && map[cur][i] != 0) {
				memo[cur][visited] = Math.min(memo[cur][visited], solve(i, visited | (1 << i)) + map[cur][i]);
			}
		}
		
		return memo[cur][visited];
	}
}
