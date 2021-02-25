package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토_S1 {

	static int N, M;
	static int[][] map;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int untomatoCnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		Queue<Point> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					q.add(new Point(i, j));
					visit[i][j] = true;
				} else if(map[i][j] == 0) {
					untomatoCnt++;
				}
			}
		}
		
		int cnt = -1;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			cnt++;
			
			while(size-- > 0) {
				int x = q.peek().x;
				int y = q.peek().y;
				q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}
					
					if(!visit[nx][ny] && map[nx][ny] == 0) {
						untomatoCnt--;
						q.add(new Point(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
		}

		if(untomatoCnt == 0) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
	}

}
