package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_세용액_G4 {

	static int N;
	static long[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		long[] result = new long[3];
		
		for(int i = 0; i < N; i++) {
			int start = i + 1;
			int end = N - 1;
			
			while(start < end) {
				
				long sum = arr[i] + arr[start] + arr[end];
				
				if(Math.abs(sum) < min) {
					min = Math.abs(sum);
					result[0] = arr[i];
					result[1] = arr[start];
					result[2] = arr[end];
				}
				
				if(sum < 0) {
					start++;
				} else {
					end--;
				}
			}
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
