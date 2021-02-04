package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합_S2 {
	
	static int N, S;
	static int[] arr;
	static int result = 0;
	
	static void partialSequence(int cnt, int num) {

		if(cnt == N) {
			return;
		}
		
		num += arr[cnt];
		
		if(num == S) {
			result++;
		}
		
		// 해당 숫자를 선택하는 경우
		partialSequence(cnt + 1, num);
		
		// 해당 숫자를 선택하지 않는 경우
		partialSequence(cnt + 1, num - arr[cnt]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		partialSequence(0, 0);
		
		System.out.println(result);
	}

}
