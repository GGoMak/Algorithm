package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2_S3 {

	static int N, M;
	static int[] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int res = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < i; j++) {
				if(A[i] - A[j] == M) {
					res++;
				}
			}
		}
		
		System.out.println(res);
	}

}
