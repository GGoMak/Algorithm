package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106_호텔_S2 {

	static Point[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		p = new Point[N];
		int[] dp = new int[1001];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = p[i].x; j <= 1000; j++) {
				dp[j] = Math.max(dp[j], dp[j - p[i].x] + p[i].y);
			}
		}
		
		for(int i = 1; i <= 1000; i++) {
			if(dp[i] >= C) {
				System.out.println(i);
				break;
			}
		}
	}
}