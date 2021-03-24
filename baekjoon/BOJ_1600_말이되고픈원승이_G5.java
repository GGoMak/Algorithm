package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원승이_G5 {

	static int K, W, H;
	static boolean[][] map;
	static int[] dxJump = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dyJump = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static class Node{
		int x, y, cnt;
		int jump;
		Node(int x, int y, int cnt, int jump) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.jump = jump;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new boolean[H][W];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				String ch = st.nextToken();
				
				if(ch.equals("1")) {
					map[i][j] = true;
				}
			}
		}
		
		int result = -1;
		
		Queue<Node> q = new LinkedList<>();
		boolean[][][] visited = new boolean[H][W][K + 1];
		visited[0][0][0] = true;
		q.add(new Node(0, 0, 0, 0));
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int cnt = q.peek().cnt;
			int jump = q.peek().jump;
			q.poll();
			
			if(x == H - 1 && y == W - 1) {
				result = cnt;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= H || ny >= W) {
					continue;
				}
				
				if(!visited[nx][ny][jump] && !map[nx][ny]) {
					visited[nx][ny][jump] = true;
					q.add(new Node(nx, ny, cnt + 1, jump));
				}
			}
			
			if(jump < K) {
				for(int i = 0; i < 8; i++) {
					int nx = x + dxJump[i];
					int ny = y + dyJump[i];
					
					if(nx < 0 || ny < 0 || nx >= H || ny >= W) {
						continue;
					}
					
					if(!visited[nx][ny][jump + 1] && !map[nx][ny]) {
						visited[nx][ny][jump + 1] = true;
						q.add(new Node(nx, ny, cnt + 1, jump + 1));
					}
				}
			}
		}
		
		System.out.println(result);
	}

}
