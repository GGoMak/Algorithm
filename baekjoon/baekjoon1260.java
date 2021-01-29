package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1260 {
	
	static int N, M, V;
	static int[][] arr;
	
	public static void bfs() {
		
		StringBuilder sb = new StringBuilder();
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		visit[V] = true;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			sb.append(n);
			sb.append(" ");
			
			for(int i = 1; i <= N; i++) {
				if(arr[n][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int start, boolean[] visit, StringBuilder sb) {
		
		visit[start] = true;
	
		sb.append(start);
		sb.append(" ");
		
		for(int i = 1; i <= N; i++) {
			if(arr[start][i] == 1 && !visit[i]) {
				dfs(i, visit, sb);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		boolean[] visit = new boolean[N + 1];

		// 방문할때마다 그 노드를 출력해도 되지만 output 횟수를 줄여 실행시간을 최적화하기 위해 StringBuilder 사용
		StringBuilder sb = new StringBuilder();
		dfs(V, visit, sb);
		System.out.println(sb);
		bfs();
	
	}

}
