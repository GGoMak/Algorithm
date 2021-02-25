package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추_S2 {

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N, M, K, T;
	static boolean[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new boolean[N][M];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x] = true;
			}
			
			boolean[][] visit = new boolean[N][M];
			
			int res = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!visit[i][j] && map[i][j]) {
						res++;
						Queue<Point> q = new LinkedList<>();
						q.add(new Point(i, j));
						visit[i][j] = true;
						
						while(!q.isEmpty()) {
							int x = q.peek().x;
							int y = q.peek().y;
							q.poll();
							
							for(int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];
								
								if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
									continue;
								}
								
								if(!visit[nx][ny] && map[nx][ny]) {
									q.add(new Point(nx, ny));
									visit[nx][ny] = true;
								}
							}
						}
					}
				}
			}
			
			sb.append(res).append("\n");
		}
		
		System.out.println(sb);

	}

}
