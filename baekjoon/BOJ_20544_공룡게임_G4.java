package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_20544_공룡게임_G4 {

	static int N;
	static long[][][][] dp;
	
	public static long solve(int pos, int height, int preheight, int flag) {
		
		if(pos == N) {
			if(flag == 1) {
				return 1;
			} else {
				return 0;
			}
		}
		
		if(dp[pos][height][preheight][flag] != 0) {
			return dp[pos][height][preheight][flag];
		}
		
		if(height == 0) {
			dp[pos][height][preheight][flag] += solve(pos + 1, 0, height, flag) % 1000000007;
			dp[pos][height][preheight][flag] += solve(pos + 1, 1, height, flag) % 1000000007;
			dp[pos][height][preheight][flag] += solve(pos + 1, 2, height, 1) % 1000000007;
		} else if(height == 1) {
			if(preheight == 0) {
				dp[pos][height][preheight][flag] += solve(pos + 1, 0, height, flag) % 1000000007;
				dp[pos][height][preheight][flag] += solve(pos + 1, 1, height, flag) % 1000000007;
				dp[pos][height][preheight][flag] += solve(pos + 1, 2, height, 1) % 1000000007;
			} else {
				dp[pos][height][preheight][flag] += solve(pos + 1, 0, height, flag) % 1000000007;
			}
		} else if(height == 2) {
			if(preheight == 0) {
				dp[pos][height][preheight][flag] += solve(pos + 1, 0, height, flag) % 1000000007;
				dp[pos][height][preheight][flag] += solve(pos + 1, 1, height, flag) % 1000000007;
			} else {
				dp[pos][height][preheight][flag] += solve(pos + 1, 0, height, flag) % 1000000007;
			}
		}
		
		return dp[pos][height][preheight][flag] % 1000000007;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		dp = new long[N + 1][3][3][2];
		
		System.out.println(solve(1, 0, 0, 0));
	}

}
