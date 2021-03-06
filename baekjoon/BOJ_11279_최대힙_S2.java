package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279_최대힙_S2 {
	
	static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(q.size() == 0) {
					sb.append("0\n");
				} else {
					sb.append(q.poll()).append("\n");
				}
			} else {
				q.add(num);
			}
		}
		
		System.out.println(sb);
	}

}
