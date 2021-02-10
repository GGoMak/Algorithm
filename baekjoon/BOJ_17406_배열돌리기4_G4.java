package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4_G4 {

	static int N, M, K, min = 987654321;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Node[] order;
	static class Node{
		int r, c, s;
		Node(int r, int c, int s){
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	
	public static void rotate(int[][] map, int r, int c, int s) {

		for(int k = 0; k < s; k++) {
			int dir = 0;
			
			int indexX = r - s + k, indexY = c - s + k;
			int temp = map[indexX][indexY];
			
			while(dir < 4) {
				
				int nx = indexX + dx[dir];
				int ny = indexY + dy[dir];
				
				if(nx < r - s + k || ny < c - s + k || nx > r + s - k || ny > c + s - k) {
					dir++;
					continue;
				}
				
				map[indexX][indexY] = map[nx][ny];
				indexX = nx;
				indexY = ny;
			}
			
			map[r - s + k][c - s + k + 1] = temp;
		}
	}
	
	public static void solve(int cnt, int[] select, boolean[] visit) {
		
		if(cnt == K) {
			int[][] tmap = new int[N + 1][M + 1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					tmap[i][j] = arr[i][j];
				}
			}
			for(int k = 0; k < select.length; k++) {
				
				rotate(tmap, order[select[k]].r, order[select[k]].c, order[select[k]].s);
			}
			
			int t = 987654321;
			
			for(int i = 1; i <= N; i++) {
				int sum = 0;
				for(int j = 1; j <= M; j++) {
					sum += tmap[i][j];
				}
				t = Math.min(sum, t);
			}
			
			min = Math.min(min, t);
		}
		
		for(int i = 1; i <= K; i++) {
			if(!visit[i]) {
				visit[i] = true;
				select[cnt] = i - 1;
				solve(cnt + 1, select, visit);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		order = new Node[K];
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			order[k] = new Node(r, c, s);
		}
		
		solve(0, new int[K], new boolean[K + 1]);
		
		
		System.out.println(min);
	}

}
