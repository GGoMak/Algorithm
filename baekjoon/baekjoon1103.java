package baekjoon1103;

import java.util.*;
import java.io.*;

public class baekjoon1103 {

	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] dp;
	static char[][] map;
	static boolean[][] visit;
	static boolean isCycle;
	
	public static int dfs(int x, int y) {
		
		if(x < 0 || y < 0 || x >= N || y >= M) {	// 맵을 벗어나면 탐색 종료
			return 0;
		}
		
		if(map[x][y] == 'H') {	// 구멍에 빠지면 탐색 종료
			return 0;
		}
		
		if(visit[x][y] == true) {	// 이미 방문했던 곳이면 사이클이므로 탐색 종료
			isCycle = true;
			return 0;
		}
		
		if(dp[x][y] != 0) {		// 이미 정보가 있는 곳이면 값 리턴(메모이제이션)
			return dp[x][y];
		}
		
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + ((dx[i]) * (map[x][y] - '0'));
			int ny = y + ((dy[i]) * (map[x][y] - '0'));
			
			// dp[x][y]는 x,y에서 갈수 있는 최대 횟수
			// 탐색이 종료될때 까지 카운트가 계속 +1이 될것이고 최종지점에 도착하면 dp의 값이 마지막 지점에서 부터 갱신되어서 거꾸로 올라올 것이다.
			dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
		}
		
		visit[x][y] = false;
		return dp[x][y];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		dp = new int[N][M];
		
		visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int result = dfs(0, 0);
		
		if(isCycle) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
		
	}

}
