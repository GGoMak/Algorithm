package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭_B2 {

	static int N, M;
	static int[] card;
	static int max = 0;
	
	public static void combination(int cnt, int start, int sum) {
		
		// sum이 N보다 크면 더이상 탐색할 필요가 없음(가지치기)
		if(sum > M) {
			return;
		}
		
		if(cnt == 0) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int i = start; i < N; i++) {
			sum += card[i];
			combination(cnt - 1, i + 1, sum);
			sum -= card[i];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		card = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		// 3개의 카드를 뽑아서 max 값 구하기
		combination(3, 0, 0);
		
		System.out.println(max);
	}

}
