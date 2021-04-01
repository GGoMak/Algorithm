package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기_G4 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.add(num);
		}
		
		long result = 0;
		
		while(pq.size() > 1) {
			int num1 = pq.poll();
			int num2 = pq.poll();
			pq.add(num1 + num2);
			result += (num1 + num2);
		}
		
		System.out.println(result);
	}

}
