package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057_마법사상어와토네이도_G4 {

	static int N;
	static int[][] map;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int sand = 0;
	
	public static double[][] rotate(double[][] rate) {
		
		double[][] temp = new double[5][5];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				temp[i][j] = rate[j][5 - 1 - i];
			}
		}
		
		return temp;
	}
	
	public static void tornado(int x, int y, int dir, double[][] rate) {

		int total = map[x][y];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				int n = (int)(map[x][y] * rate[i][j]);
				map[x - 2 + i][y - 2 + j] += n;
				total -= n;
			}
		}
		
		if(dir == 0) {
			map[x][y - 1] += total;
		} else if(dir == 1) {
			map[x + 1][y] += total;
		} else if(dir == 2) {
			map[x][y + 1] += total;
		} else {
			map[x - 1][y] += total;
		}
		map[x][y] = 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 4][N + 4];
		
		for(int i = 2; i < N + 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 2; j < N + 2; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int indexX = N / 2 + 2, indexY = N / 2 + 2;
		int dir = 0, depth = 1;
		
		double[][] rate = {{0, 0, 0.02, 0, 0}, {0, 0.1, 0.07, 0.01, 0}, {0.05, 0, 0, 0, 0}, {0, 0.1, 0.07, 0.01, 0}, {0, 0, 0.02, 0, 0}};
		
		while(depth < N) {
			for(int i = 0; i < depth; i++) {
				indexX = indexX + dx[dir];
				indexY = indexY + dy[dir];
				
				tornado(indexX, indexY, dir, rate);
			}
			rate = rotate(rate);
			dir++;
			dir %= 4;
			if(dir % 2 == 0) {
				depth++;
			}
		}
		
		for(int i = 0; i < N - 1; i++) {
			indexX = indexX + dx[0];
			indexY = indexY + dy[0];
			tornado(indexX, indexY, 0, rate);
		}
		
		for(int i = 0; i < N + 4; i++) {
			for(int j = 0; j < N + 4; j++) {
				if(i < 2) {
					sand += map[i][j];
				} else if(i >= 2 && (j < 2 || j > N + 1)) {
					sand += map[i][j];
				} else if(i > N + 1) {
					sand += map[i][j];
				}
			}
		}
		
		System.out.println(sand);
	}

}
