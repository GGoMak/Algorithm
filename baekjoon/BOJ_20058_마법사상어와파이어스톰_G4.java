package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058_마법사상어와파이어스톰_G4 {

	static int N, Q;
	static int[][] map;
	static int size;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	
	public static void melt() {
		
		LinkedList<Point> list = new LinkedList<>();
		
		for(int i = 1; i <= size; i++) {
			for(int j = 1; j <= size; j++) {
				if(map[i][j] > 0) {
					int cnt = 0;
					
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx < 1 || ny < 1 || nx > size || ny > size) {
							continue;
						}
						
						if(map[nx][ny] > 0) {
							cnt++;
						}
					}
					
					if(cnt < 3) {
						list.add(new Point(i, j));
					}
				}
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			map[list.get(i).x][list.get(i).y]--;
		}
	}
	
	public static int[][] rotate(int[][] input) {
		
		int s = input.length;
		
		int[][] temp = new int[s][s];

		for(int i = 0; i < s; i++) {
			for(int j = 0; j < s; j++) {
				temp[i][j] = input[s - 1 - j][i];
			}
		}
		
		return temp;
	}
	
	public static void fireStorm(int L) {
		
		int bound = (int)Math.pow(2, L);
		
		for(int i = 1; i <= size; i += bound) {
			for(int j = 1; j <= size; j += bound) {
				int[][] tempMap = new int[bound][bound];
				
				for(int p = 0; p < bound; p++) {
					for(int q = 0; q < bound; q++) {
						tempMap[p][q] = map[i + p][j + q];
					}
				}
				
				tempMap = rotate(tempMap);
				
				for(int p = 0; p < bound; p++) {
					for(int q = 0; q < bound; q++) {
						map[p + i][q + j] = tempMap[p][q];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		size = (int)Math.pow(2, N);
		
		map = new int[size + 2][size + 2];
		
		for(int i = 1; i <= size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			fireStorm(L);
			melt();
		}
		
		int sum = 0;
		
		for(int i = 1; i <= size; i++) {
			for(int j = 1; j <= size; j++) {
				sum += map[i][j];
			}
		}
		
		int max = 0;
		boolean[][] visit = new boolean[size + 2][size + 2];
		Queue<Point> q = new LinkedList<>();
		
		for(int i = 1; i <= size; i++) {
			for(int j = 1; j <= size; j++) {
				if(!visit[i][j] && map[i][j] > 0) {
					q.add(new Point(i, j));
					visit[i][j] = true;
					
					int cnt = 0;
					
					while(!q.isEmpty()) {
						int nx = q.peek().x;
						int ny = q.peek().y;
						q.poll();
						
						cnt++;
						
						for(int k = 0; k < 4; k++) {
							int nnx = nx + dx[k];
							int nny = ny + dy[k];
							
							if(nnx < 1 || nny < 1 || nnx > size || nny > size) {
								continue;
							}
							
							if(!visit[nnx][nny] && map[nnx][nny] > 0) {
								q.add(new Point(nnx, nny));
								visit[nnx][nny] = true;
							}
						}
					}
					
					max = Math.max(cnt, max);
				}
			}
		}
		
		System.out.println(sum);
		System.out.println(max);
	}

}
