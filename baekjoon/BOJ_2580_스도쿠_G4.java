package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠_G4 {

	static int[][] map = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	static List<Node> blank = new ArrayList<>();
	
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean isPossible(int x, int y, int k) {
		
		// 가로 세로 검사
		for(int i = 0; i < 9; i++) {
			if(map[i][y] == k) {
				return false;
			}
			if(map[x][i] == k) {
				return false;
			}
		}
		
		int xx = x / 3;
		int yy = y / 3;
		
		// 3*3 네모칸 검사
		for(int i = 3 * xx; i < (3 * xx) + 3; i++) {
			for(int j = 3 * yy; j < (3 * yy) + 3; j++) {
				if(map[i][j] == k) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void solve(int x, int y, int cnt) {
		
		if(cnt == blank.size()) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0);
		}
		
		
		Node n = blank.get(cnt);
		// cnt번째 빈칸에 1~9까지 넣어보기
		for(int k = 1; k <= 9; k++) {
			if(isPossible(n.x, n.y, k)) {
				map[n.x][n.y] = k;
				solve(n.x, n.y, cnt + 1);
				map[n.x][n.y] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					Node n = new Node(i, j);
					blank.add(n);
				}
			}
		}
		
		solve(0, 0, 0);
	}

}
