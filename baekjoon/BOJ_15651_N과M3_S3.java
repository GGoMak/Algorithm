package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_N과M3_S3 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] select;
	
	static void permutation(int cnt) {
		
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(select[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			// select 배열은 반복문을 돌때마다 갱신되기 때문에 0으로 초기화할 필요가 없음
			select[cnt] = i;
			permutation(cnt + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		select = new int[M];
		permutation(0);
		
		System.out.print(sb);
	}

}
