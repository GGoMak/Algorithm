package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_10814_나이순정렬_S5 {
	
	static int N;
	
	static class Node implements Comparable<Node>{
		int age;
		String name;
		int idx;
		Node(int age, String name, int idx){
			this.age = age;
			this.name = name;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.age == o.age) {
				return Integer.compare(this.idx, o.idx);
			} else
				return Integer.compare(this.age, o.age);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		List<Node> arr = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Node(Integer.parseInt(st.nextToken()), st.nextToken(), i));
		}
		
		Collections.sort(arr);
		
		for(int i = 0; i < N; i++) {
			System.out.printf("%d %s\n", arr.get(i).age, arr.get(i).name);
		}
	}

}
