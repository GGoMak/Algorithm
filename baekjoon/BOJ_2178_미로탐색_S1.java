package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색_S1 {
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static class Node{
		int x, y, cnt;
		Node(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				if(str.charAt(j) == '1') {
					map[i][j] = true;
				}
			}
		}
		
		boolean[][] visit = new boolean[N][M];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 1));
		visit[0][0] = true;
		
		int result = 0;
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int cnt = q.peek().cnt;
			q.poll();
			
			if(x == N - 1 && y == M - 1) {
				result = cnt;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				
				if(!visit[nx][ny] && map[nx][ny]) {
					q.add(new Node(nx, ny, cnt + 1));
					visit[nx][ny] = true;
				}
			}
		}
		
		System.out.println(result);
	}

}
