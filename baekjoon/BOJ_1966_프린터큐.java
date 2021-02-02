package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {

	static int T;
	static StringBuilder sb = new StringBuilder();
	
	static class Node {
		int idx, importance;
		Node(int idx, int importance){
			this.idx = idx;
			this.importance = importance;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<Node> q = new LinkedList<>();
			List<Integer> importance = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int k = Integer.parseInt(st.nextToken());
				Node n = new Node(i, k);
				q.add(n);
				importance.add(k);
			}
			
			Collections.sort(importance, Collections.reverseOrder());
			int cnt = 1;
			
			while(!q.isEmpty()) {
				Node n = q.poll();
				
				if(n.importance >= importance.get(0) && n.idx == M) {
					sb.append(cnt).append("\n");
					break;
				}
				
				else if(n.importance < importance.get(0)){
					q.add(n);
				} else {
					importance.remove(0);
					cnt++;
				}
			}
		}
		
		System.out.println(sb);
	}

}
