package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합_G4 {

	static int N, S;
	static int[] arr;
	static int min = 987654321;
	
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
		
		int start = 0, end = 0;
		int sum = 0;
		
		while(end <= N) {
			
			if(sum <= S) {
				sum += arr[end];
				end++;
			} else {
				sum -= arr[start];
				start++;
			}
			
			if(sum >= S) {
				min = Math.min(min, end - start);
			}
		}
		
		if(min == 987654321) {
			System.out.println(0);
		} else {
			System.out.println(min);
		}
	}

}
