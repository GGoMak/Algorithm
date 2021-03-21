package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16562_친구비_G3 {

	static int N, M, K;
	static int[] parents, arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		parents = new int[N + 1];
		arr = new int[N + 1];

		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			union(u, v);
		}
		
		int sum = 0;
		
		for(int i = 1; i <= N; i++) {
			int tempParent = find(i);
			
			if(tempParent != 0) {
				sum += arr[tempParent];
				union(0, tempParent);
			}
		}
		
		if(sum <= K) {
			System.out.println(sum);
		} else {
			System.out.println("Oh no");
		}
		
	}
	
	public static int find(int x) {
		if(x == parents[x]) {
			return x;
		} else {
			return parents[x] = find(parents[x]);
		}
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(arr[x] < arr[y]) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
	}
}
