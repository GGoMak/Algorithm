package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_12789_도키도키간식드리미_S4 {
	
	static int N;
	static ArrayList <Integer> arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> s = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		int order = 1;
		
		while(!arr.isEmpty()) {
			if(arr.get(0) == order) {
				arr.remove(0);
				order++;
			} else if(!s.isEmpty() && s.peek() == order){
				s.pop();
				order++;
			} else {
				s.push(arr.get(0));
				arr.remove(0);
			}
		}
		
		while(!s.isEmpty() && s.peek().equals(order)) {
			s.pop();
			order++;
		}
		
		if(order == N + 1) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}

}
