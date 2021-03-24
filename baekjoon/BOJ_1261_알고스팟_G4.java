package Baekjoon;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;
import java.io.BufferedReader;

public class BOJ_1261_알고스팟_G4 {

	static int N, M;
	static boolean[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static class Node{
		int x, y, cnt;
		Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				char ch = input.charAt(j);
				
				if(ch == '1') {
					map[i][j] = true;
				}
			}
		}
		
		int result = 987654321;
		
		Queue<Node> q = new LinkedList<>();
		int[][] visited = new int[N][M];
		q.add(new Node(0, 0, 0));
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = 987654321;
			}
		}
		visited[0][0] = 0;
	
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int cnt = q.peek().cnt;
			q.poll();
			
			if(x == N - 1 && y == M - 1) {
				result = Math.min(result, cnt);
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				
				if(map[nx][ny]) {
					if(cnt + 1 < visited[nx][ny]) {
						q.add(new Node(nx, ny, cnt + 1));
						visited[nx][ny] = cnt + 1;
					}
				} else {
					if(cnt < visited[nx][ny]) {
						q.add(new Node(nx, ny, cnt));
						visited[nx][ny] = cnt;
					}
				}
				
			}
		}
		
		System.out.println(result);
	}

}
