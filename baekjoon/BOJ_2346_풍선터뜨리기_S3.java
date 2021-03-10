package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2346_풍선터뜨리기_S3 {

	static int N;
	static Deque<Point> balloon = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			balloon.add(new Point(i + 1, Integer.parseInt(st.nextToken())));
		}
		
		while(true) {
			int num = balloon.peekFirst().y;
			sb.append(balloon.peekFirst().x).append(" ");
			balloon.pollFirst();
			
			if(balloon.size() == 0) {
				break;
			}
			
			if(balloon.size() == num) {
				continue;
			}
			
			if(num > 0) {
				for(int i = 0; i < num - 1; i++) {
					balloon.addLast(balloon.pollFirst());
				}
			} else {
				for(int i = 0; i < num * -1; i++) {
					balloon.addFirst(balloon.pollLast());
				}
			}
		}
		
		System.out.println(sb);
	}

}
