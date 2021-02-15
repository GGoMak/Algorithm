package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동_S2 {

	static int T; 
	static StringBuilder sb = new StringBuilder();
	
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	
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
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int L = Integer.parseInt(br.readLine());
			boolean[][] map = new boolean[L][L];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nightX = Integer.parseInt(st.nextToken());
			int nightY = Integer.parseInt(st.nextToken());
			map[nightX][nightY] = true;
			st = new StringTokenizer(br.readLine());
			int desX = Integer.parseInt(st.nextToken());
			int desY = Integer.parseInt(st.nextToken());
			
			Queue<Node> q = new LinkedList<>();
			boolean[][] visit = new boolean[L][L];
			visit[nightX][nightY] = true;
			q.add(new Node(nightX, nightY, 0));
			int result = 0;
			
			while(!q.isEmpty()) {
				int x = q.peek().x;
				int y = q.peek().y;
				int cnt = q.peek().cnt;
				q.poll();
				
				if(x == desX && y == desY) {
					result = cnt;
					break;
				}
				
				for(int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
						
					if(nx < 0 || ny < 0 || nx >= L || ny >= L) {
						continue;
					}
						
					if(!visit[nx][ny]) {
						q.add(new Node(nx, ny, cnt + 1));
						visit[nx][ny] = true;
					}
				}
			}
			
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
		
	}

}
