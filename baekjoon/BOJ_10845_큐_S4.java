package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10845_큐_S4 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		
		List<Integer> q = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String operator = st.nextToken();
			int num = 0;
			
			switch(operator) {
				case "push":
					num = Integer.parseInt(st.nextToken());
					q.add(num);
					break;
				case "pop":
					if(q.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(q.get(0)).append("\n");
						q.remove(0);
					}
					break;
				case "size":
					sb.append(q.size()).append("\n");
					break;
				case "empty":
					if(q.isEmpty()) {
						sb.append("1").append("\n");
					} else {
						sb.append("0").append("\n");
					}
					break;
				case "front":
					if(q.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(q.get(0)).append("\n");
					}
					break;
				case "back":
					if(q.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(q.get(q.size() - 1)).append("\n");
					}
					break;
			}
		}
		
		System.out.println(sb);
	}

}
