package baekjoon1039;

import java.util.*;
import java.io.*;

public class baekjoon1039 {
	
	static int N, K;
	static String str;
	static int max = -1;
	
	static class Node{
		String str;
		int cnt;
		Node(String str, int cnt){
			this.str = str;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		str = Integer.toString(N);
		
		HashSet<String> visit = new HashSet<>();
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(str, 0));
		int tcnt = 0;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(tcnt != n.cnt) {
				tcnt = n.cnt;
				visit.clear();
			}
			
			if(n.cnt == K) {
				max = Math.max(max, Integer.parseInt(n.str));
				continue;
			}
			
			for(int i = 0; i < n.str.length(); i++) {
				for(int j = i + 1; j < n.str.length(); j++) {
					if(i == 0 && n.str.charAt(j) == '0') {
						continue;
					}
					
					StringBuilder sb = new StringBuilder(n.str);
					char t = sb.charAt(i);
					sb.setCharAt(i, sb.charAt(j));
					sb.setCharAt(j, t);
					
					if(!visit.contains(sb.toString())) {
						q.add(new Node(sb.toString(), n.cnt + 1));
						visit.add(sb.toString());
					}
				}
			}
		}
		
		System.out.println(max);
		
	}
}
