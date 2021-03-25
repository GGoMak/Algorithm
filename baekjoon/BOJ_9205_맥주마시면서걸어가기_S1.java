package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기_S1 {

	static int T;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			List<Point> node = new ArrayList<>();
			
			for(int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				node.add(new Point(x, y));
			}
			
			Queue<Point> q = new LinkedList<>();
			boolean[] visited = new boolean[N + 2];
			q.add(new Point(node.get(0).x, node.get(0).y));
			visited[0] = true;
			
			int endX = node.get(node.size() - 1).x;
			int endY = node.get(node.size() - 1).y;
			boolean check = false;
			
			while(!q.isEmpty()) {
				int x = q.peek().x;
				int y = q.peek().y;
				q.poll();
				
				if(x == endX && y == endY) {
					check = true;
					break;
				}
				
				for(int i = 1; i < N + 2; i++) {
					Point point = node.get(i);
					
					if(!visited[i] && Math.abs(point.x - x) + Math.abs(point.y - y) <= 1000) {
						q.add(new Point(point.x, point.y));
						visited[i] = true;
					}
				}
			}
			
			if(check) {
				sb.append("happy").append("\n");
			} else {
				sb.append("sad").append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
