package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_2842_집배원한상덕_P5 {

	static int N;
	static char[][] map;
	static int[][] height;
	static int pX, pY;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static boolean[][] visit;
	static ArrayList<Point> house;
	
	public static void dfs(int x, int y, int max, int min) {
		
		if(height[x][y] < min || height[x][y] > max) {
			return;
		}
		
		visit[x][y] = true;
		
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			
			if(!visit[nx][ny]) {
				dfs(nx, ny, max, min);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		height = new int[N][N];
		house = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
				
				if(map[i][j] == 'P') {
					pX = i;
					pY = j;
				} else if(map[i][j] == 'K') {
					house.add(new Point(i, j));
				}
			}
		}
		
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				set.add(height[i][j]);
			}
		}
		
		ArrayList<Integer> tired = new ArrayList<>(set);
		//Collections.sort(tired);
		int result = 987654321;
		int left = 0, right = 0;
		
		while(right < tired.size()) {
			while(left <= right) {
				boolean check = true;
				visit = new boolean[N][N];
				dfs(pX, pY, tired.get(right), tired.get(left));
				
				for(int i = 0; i < house.size(); i++) {
					if(!visit[house.get(i).x][house.get(i).y]) {
						check = false;
						break;
					}
				}
				
				if(!check) {
					break;
				}
				result = Math.min(result, tired.get(right) - tired.get(left));
				left++;
			}
			
			right++;
		}
		
		System.out.println(result);
	}

}
