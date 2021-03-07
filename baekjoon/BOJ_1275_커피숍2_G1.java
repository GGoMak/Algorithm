package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1275_커피숍2_G1 {

	static int N, Q;
	static long[] tree;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void init(int node, int start, int end) {
		
		if(start == end) {
			tree[node] = arr[start];
			return;
		}
		
		init(node * 2, start, (start + end) / 2);
		init(node * 2 + 1, (start + end) / 2 + 1, end);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
	
	public static long query(int node, int start, int end, int i, int j) {
		
		if(j < start || i > end) {
			return 0;
		}
	
		else if(i <= start && end <= j) {
			return tree[node];
		}
		
		return query(node * 2, start, (start + end) / 2, i, j) + query(node * 2 + 1, (start + end) / 2 + 1, end, i, j);
	}
	
	public static void update(int node, int start, int end, int i, long j) {
		
		if(i < start || i > end) {
			return;
		}
		
		tree[node] += j;
		
		if(start == end) {
			return;
		}
		
		update(node * 2, start, (start + end) / 2, i, j);
		update(node * 2 + 1, (start + end) / 2 + 1, end, i , j);
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		tree = new long[N * 4];
		
		st = new StringTokenizer(br.readLine());
		for(int i= 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1, 1, N);
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(x > y) {
				int temp = y;
				y = x;
				x = temp;
			}
			
			sb.append(query(1, 1, N, x, y)).append("\n");
			
			long diff = (long)b - (long)arr[a];
			arr[a] = b;
			update(1, 1, N, a, diff);
		}
		
		System.out.println(sb);
	}

}
