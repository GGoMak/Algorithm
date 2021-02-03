package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_최대공약수와최소공배수 {

	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int gcf = 0;
		
		// 최대공약수 구하기
		// 1부터 두 수를 나누어 가며 둘다 나누어지면 공약수, 마지막으로 나누어지는 값이 최대공약수
		for(int i = 1; i <= Math.min(N, M); i++) {
			if(N % i == 0 && M % i == 0) {
				gcf = i;
			}
		}
		
		int lcm = Math.max(N, M);
		int divisor = Math.min(N, M);
		
		// 최소공배수 구하기
		// 큰 놈의 배수가 작은수로 나누어지면 최소공배수
		while(lcm % divisor != 0) {
			lcm += Math.max(N, M);
		}
		
		System.out.println(gcf);
		System.out.println(lcm);
	}

}