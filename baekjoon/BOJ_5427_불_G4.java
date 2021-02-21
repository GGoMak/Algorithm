package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_불_G4 {

	static int T;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static StringBuilder sb = new StringBuilder();
	
	static class Node{
		int x, y, cnt;
		char ch;
		Node(int x, int y, char ch, int cnt){
			this.x = x;
			this.y = y;
			this.ch = ch;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[N][M];
			int startX = 0, startY = 0;
			Queue<Node> q = new LinkedList<>();
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					map[i][j] = input.charAt(j);
					
					if(map[i][j] == '@') {
						startX = i;
						startY = j;
					} else if(map[i][j] == '*') {
						q.add(new Node(i, j, '*', 0));
					}
				}
			}
			
			boolean[][] visit = new boolean[N][M];
			q.add(new Node(startX, startY, '@', 0));
			visit[startX][startY] = true;
			
			int res = 987654321;
			
			while(!q.isEmpty()) {
				int x = q.peek().x;
				int y = q.peek().y;
				char ch = q.peek().ch;
				int cnt = q.peek().cnt;
				q.poll();
				
				if(ch == '@' && (x == 0 || y == 0 || x == N - 1 || y == M - 1)) {
					res = cnt + 1;
					break;
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}
				
					if(!visit[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
						q.add(new Node(nx, ny, ch, cnt + 1));
						map[nx][ny] = ch;
						visit[nx][ny] = true;
					}
				}
			}
			
			if(res != 987654321) {
				sb.append(res).append("\n");
			} else {
				sb.append("IMPOSSIBLE\n");
			}
		}
		
		System.out.println(sb);
	}

}
