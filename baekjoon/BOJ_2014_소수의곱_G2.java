package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2014_소수의곱_G2 {

	static int K, N;
	static long[] arr;
	static PriorityQueue<Long> q = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new long[K];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			q.add(arr[i]);
		}
		
		long num = 0;
		
		for(int i = 0; i < N; i++) {
			num = q.poll();
			
			for(int j = 0; j < K; j++) {
				q.add(arr[j] * num);
				
				if(num % arr[j] == 0) {
					break;
				}
			}
		}
		
		System.out.println(num);
	}

}
