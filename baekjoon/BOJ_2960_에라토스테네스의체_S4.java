package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2960_에라토스테네스의체_S4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[1001];
		
		int result = 0;
		
		for(int i = 2; i <= N; i++) {
			if(visit[i]) {
				continue;
			}
			
			for(int j = i; j <= N; j += i) {
				if(visit[j]) {
					continue;
				}
				K--;
				
				if(K == 0) {
					result = j;
					break;
				}
				visit[j] = true;
			}
		}
		
		
		System.out.println(result);
		
	}

}
