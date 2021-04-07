package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11967_불켜기_G4 {

	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<Point> switches[][];
	static boolean[][] visit, map, light;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1][N + 1];
		switches = new ArrayList[N + 1][N + 1];
		light = new boolean[N + 1][N + 1];
		map = new boolean[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				switches[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());
			switches[x][y].add(new Point(tx, ty));
		}
		
		Queue<Point> q = new LinkedList<>();
		visit[1][1] = true;
		light[1][1] = true;
		map[1][1] = true;
		q.add(new Point(1, 1));
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			for(int i = 0; i < switches[x][y].size(); i++) {
				int nx = switches[x][y].get(i).x;
				int ny = switches[x][y].get(i).y;
				light[nx][ny] = true;
				
				if(map[nx][ny]) {
					q.add(new Point(nx, ny));
				}
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx <= 0 || ny <= 0 || nx > N || ny > N) {
					continue;
				}
				
				map[nx][ny] = true;
				
				if(!visit[nx][ny] && light[nx][ny]) {
					q.add(new Point(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
		
		int result = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(light[i][j]) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}

}
