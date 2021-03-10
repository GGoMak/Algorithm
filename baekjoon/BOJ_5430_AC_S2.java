package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5430_AC_S2 {

	static int T;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringBuilder func = new StringBuilder(br.readLine());
			
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			str = str.substring(1, str.length() - 1);
			Deque<Integer> arr = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(str, ",");
			
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean flag = true;
			StringBuilder temp = new StringBuilder();
			boolean check = true;
			
			for(int i = 0; i < func.length(); i++) {
				if(func.charAt(i) == 'R') {
					flag = !flag;
				} else {
					if(arr.size() == 0) {
						check = false;
						break;
					}
					
					if(flag) {
						arr.pollFirst();
					} else {
						arr.pollLast();
					}
				}
			}
			
			if(check) {
				if(flag) {	
					while(!arr.isEmpty()) {
						temp.append(arr.pollFirst()).append(",");
					}
				} else {
					while(!arr.isEmpty()) {
						temp.append(arr.pollLast()).append(",");
					}
				}
				
				if(temp.length() == 0) {
					sb.append("[]\n");
				} else {
					sb.append("[").append(temp.substring(0, temp.length() - 1)).append("]").append("\n");
				}
			} else {
				sb.append("error").append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
