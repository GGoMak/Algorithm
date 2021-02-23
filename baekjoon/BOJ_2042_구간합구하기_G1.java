package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2042_구간합구하기_G1 {

	static int N, M, K;
	static long[] tree;
	static long[] arr;
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
	
	public static void update(int node, int start, int end, int i, long num) {
		
		if(i < start || i > end) {
			return;
		}
		
		tree[node] += num;
		
		if(start != end) {
			update(node * 2, start, (start + end) / 2, i, num);
			update(node * 2 + 1, (start + end) / 2 + 1, end, i, num);
		}
	}
	
	public static long query(int node, int start, int end, int i, int j) {
		
		if(end < i || start > j) {
			return 0;
		} 
		
		else if(i <= start && end <= j) {
			return tree[node];
		}
		
		return query(node * 2, start, (start + end) / 2, i, j) + query(node * 2 + 1, (start + end) / 2 + 1, end, i, j);
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		tree = new long[N * 4 + 1];
		arr = new long[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		
		init(1, 1, N);
		
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				long num = c - arr[b];
				arr[b] = c;
				update(1, 1, N, b, num);
			} else if(a == 2) {
				sb.append(query(1, 1, N, b, (int)c)).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
