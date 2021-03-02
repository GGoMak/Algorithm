package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_2517_달리기_P4 {

	static int N;
	static int[] tree;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static int query(int node, int start, int end, int i, int j) {
		
		if(j < start || i > end) {
			return 0;
		}
		
		if(i <= start && end <= j) {
			return tree[node];
		}
		
		return query(node * 2, start, (start + end) / 2, i, j) + query(node * 2 + 1, (start + end) / 2 + 1, end, i, j);
	}
	
	public static void update(int node, int start, int end, int i) {
		
		if(i < start || i > end) {
			return;
		}
		
		tree[node]++;
		
		if(start == end) {
			return;
		}
		
		update(node * 2, start, (start + end) / 2, i);
		update(node * 2 + 1, (start + end) / 2 + 1, end, i);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		tree = new int[N * 4];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] tempArr = arr.clone();
		Arrays.sort(tempArr);
		
		HashMap<Integer, Integer> m = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			m.put(tempArr[i], i + 1);
		}
		
		for(int i = 0; i < N; i++) {
			int lowPlayerCnt = query(1, 1, N, 1, m.get(arr[i]));
			
			sb.append(i - lowPlayerCnt + 1).append("\n");
			update(1, 1, N, m.get(arr[i]));
		}
		
		System.out.println(sb);
		
	}

}
