package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {

	static int N, M;
	static int map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		boolean[] visit = new boolean[N + 1];
		int result = 0;
		visit[1] = true;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			for(int i = 1; i <= N; i++) {
				if(map[n][i] == 1 && !visit[i]) {
					q.add(i);
					result++;
					visit[i] = true;
				}
			}
		}
		
		System.out.println(result);
	}

}
