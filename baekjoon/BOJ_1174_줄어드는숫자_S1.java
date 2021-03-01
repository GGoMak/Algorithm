package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1174_줄어드는숫자_S1 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		if(N <= 10) {
			System.out.println(N - 1);
			return;
		} 
		else if(N == 1023) {
			System.out.println("9876543210");
			return;
		}
		
		else if(N > 1023) {
			System.out.println(-1);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			q.add(i);
			N--;
		}
		
		while(true) {
			int n = q.poll();
			int tmp = n % 10;
			
			for(int i = 0; i < tmp; i++) {
				q.add(n * 10 + i);
				N--;
				
				if(N == 0) {
					System.out.println(n * 10 + i);
					return;
				}
			}
		}
	}
}
