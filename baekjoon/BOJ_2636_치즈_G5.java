package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈_G5 {

	static int N, M;
	static boolean[][] cheeseMap;
	static int cheeseCount = 0;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cheeseMap = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				String num = st.nextToken();
				if(num.equals("1")) {
					cheeseMap[i][j] = true;
					cheeseCount++;
				}
			}
		}
		
		int remainCheeseCount = cheeseCount;
		int time = 0;
		
		while(cheeseCount > 0) {
			List<Point> list = new ArrayList<>();
			
			// q에 녹일 치즈 넣기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(cheeseMap[i][j]) {
						if(isDeleted(i, j)) {
							list.add(new Point(i, j));
						}
					}
				}
			}
			
			// 치즈 녹이기
			for(int i = 0; i < list.size(); i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				
				cheeseMap[x][y] = false;
				cheeseCount--;
			}
			time++;
			// 녹기 1시간 전의 cheese개수를 저장
			if(cheeseCount != 0) {
				remainCheeseCount = cheeseCount;
			}
		}
		
		System.out.println(time);
		System.out.println(remainCheeseCount);
		
	}
	
	static boolean isDeleted(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		q.add(new Point(x, y));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int nx = q.peek().x;
			int ny = q.peek().y;
			q.poll();
			
			if(nx == 0 || ny == 0 || nx == N - 1 || ny == M - 1) {
				return true;
			}
			
			for(int i = 0; i < 4; i++) {
				int nnx = nx + dx[i];
				int nny = ny + dy[i];
				
				if(nnx < 0 || nny < 0 || nnx >= N || nny >= M) {
					continue;
				}
				
				if(!visit[nnx][nny] && !cheeseMap[nnx][nny]) {
					visit[nnx][nny] = true;
					q.add(new Point(nnx, nny));
				}
			}
		}
		
		return false;
	}

}
