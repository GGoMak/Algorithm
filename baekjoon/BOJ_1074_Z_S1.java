package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z_S1 {

	static int N, R, C;
	static int num;
	
	public static void solve(int x, int y, int size) {
		
		if(x == R && y == C) {
			System.out.println(num);
			System.exit(0);
		}
		
		if(size == 1) {
			num++;
			return;
		}
		
		if(!(R >= x && x + size > R && C >= y && y + size > C)) {
			num += size * size;
			return;
		}
		
		solve(x, y, size / 2);
		solve(x, y + size/2, size / 2);
		solve(x + size/2, y, size / 2);
		solve(x + size/2, y + size/2, size / 2);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		solve(0, 0, (int)Math.pow(2, N));
	}

}
