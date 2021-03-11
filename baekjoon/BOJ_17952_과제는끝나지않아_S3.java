package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17952_과제는끝나지않아_S3 {

	static int N;
	
	static class Node {
		int score, time;
		Node(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Stack<Node> s = new Stack<>();
		
		int res = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int order = Integer.parseInt(st.nextToken());
			
			if(order == 1) {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken()) - 1;
				
				if(time == 0) {
					res += score;
					continue;
				}
				
				Node n = new Node(score, time);
				s.add(n);
			} else {
				if(!s.isEmpty()) {
					Node n = s.pop();
					n.time--;
					if(n.time == 0) {
						res += n.score;
						continue;
					}
					
					s.push(n);
				}
			}
		}
		
		System.out.println(res);
	}

}
