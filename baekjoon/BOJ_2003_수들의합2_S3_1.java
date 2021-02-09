package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2_S3_1 {

	static int N, M;
	static int[] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int startIdx = 0, endIdx = 0;
		int res = 0;
		int sum = 0;
		
		while(endIdx <= N) {
			if(sum < M) {
				sum += A[endIdx];
				endIdx++;
			} else {
				sum -= A[startIdx];
				startIdx++;
			}
			
			if(sum == M) {
				res++;
			}
		}
		
		System.out.println(res);
	}

}
