package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11003_최솟값찾기_P5 {

	static int N, L;
	static StringBuilder sb = new StringBuilder();
	
	static class Node{
		int num, idx;
		Node(int num, int idx){
			this.num = num;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		Deque<Node> deque = new ArrayDeque<>(); 
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// num보다 큰 수는 deque에서 뺌
			while(!deque.isEmpty() && num < deque.peekLast().num) {
				deque.pollLast();
			}
			
			// deque의 맨 앞(최솟값)이 빠져야 하는 인덱스이면 빼줌
			if(!deque.isEmpty() && deque.peekFirst().idx <= i - L) {
				deque.pollFirst();
			}
			
			deque.addLast(new Node(num, i));
			
			// deque의 맨 앞이 최솟값
			sb.append(deque.peekFirst().num).append(" ");
		}
		
		System.out.println(sb);
	}

}
