package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑_G5 {

	static int N;
	static Stack<Node> s;
	static StringBuilder sb = new StringBuilder();
	
	static class Node{
		int idx;
		int height;
		Node(int idx, int height){
			this.idx = idx;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		s = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {

			int height = Integer.parseInt(st.nextToken());
			
			// 스택이 비어 있으면 레이저를 맞을 타워가 없음, 자신을 넣음
			if(s.isEmpty()) {
				sb.append("0 ");
				s.push(new Node(i, height));
				continue;
			}
			
			// 스택이 비어있지 않으면 자신보다 높은 타워를 만날때 까지 pop
			while(!s.isEmpty() && s.peek().height < height) {
				s.pop();
			}
			
			// 자신 보다 높은 타워가 없는경우 자신을 스택에 넣음
			if(s.isEmpty()) {
				sb.append("0 ");
			}
			// 스택의 top이 자신보다 높은 타워
			else {
				sb.append(s.peek().idx).append(" ");
			}
			
			s.push(new Node(i, height));
		}
		
		System.out.println(sb);
	}

}
