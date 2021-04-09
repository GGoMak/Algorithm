package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2411_아이템먹기_G4 {

	static int N, M, A, B;
	static boolean[][] map;
	static int[][] dp;
	static List<Point> item = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new boolean[N + 1][M + 1];
		dp = new int[N + 1][M + 1];
		
		for(int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			item.add(new Point(x, y));
		}
		item.add(new Point(N, M));
		
		for(int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = true;
		}
		
		Collections.sort(item, (o1, o2) -> {
			if(o1.y < o2.y) {
				return -1;
			} else if(o1.y == o1.y){
				return Integer.compare(o1.x, o2.x);
			} else {
				return 1;
			}
		});
		
		int curX = 1, curY = 1;
		dp[0][1] = 1;
		
		for(int i = 0; i < item.size(); i++) {
			int targetX = item.get(i).x;
			int targetY = item.get(i).y;
			
			for(int p = curX; p <= targetX; p++) {
				for(int q = curY; q <= targetY; q++) {
					if(map[p][q]) {
						dp[p][q] = 0;
					} else if(!map[p - 1][q] && !map[p][q - 1]) {
						dp[p][q] = dp[p - 1][q] + dp[p][q - 1];
					} else if(!map[p - 1][q]) {
						dp[p][q] = dp[p - 1][q];
					} else if(!map[p][q - 1]) {
						dp[p][q] = dp[p][q - 1];
					}
				}
			}
			
			curX = targetX;
			curY = targetY;
		}
		
		System.out.println(dp[N][M]);
	}

}
