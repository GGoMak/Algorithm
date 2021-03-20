package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021_회전하는큐_S4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dq = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			dq.add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		
		int result = 0;
		
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			Iterator<Integer> it = dq.iterator();
			int targetIdx = 0;
			
			while(it.hasNext()) {
				if(it.next() == num) {
					break;
				}
				targetIdx++;
			}
			
			while(true) {
				if(dq.peekFirst() == num) {
					dq.pollFirst();
					break;
				} else if(targetIdx > dq.size() / 2) {
					dq.addFirst(dq.pollLast());
					result++;
				} else {
					dq.addLast(dq.pollFirst());
					result++;
				}
			}
		}
		
		System.out.println(result);
	}

}
