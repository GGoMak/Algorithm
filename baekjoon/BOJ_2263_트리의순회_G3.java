package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2263_트리의순회_G3 {

	static int N;
	static int[] inorder, postorder, idx;
	static StringBuilder sb = new StringBuilder();
	public static void solve(int in_start, int in_end, int post_start, int post_end) {
		
		if(in_start > in_end || post_start > post_end) {
			return;
		}
		
		int root = postorder[post_end];
		sb.append(root).append(" ");
		
		int i = idx[root];
		int left = i - in_start;
		
		solve(in_start, i - 1, post_start, post_start + left - 1);
		solve(i + 1, in_end, post_start + left, post_end - 1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		inorder = new int[N];
		postorder = new int[N];
		idx = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			idx[inorder[i]] = i;
		}
		
		solve(0, N - 1, 0, N - 1);
		
		System.out.println(sb);
	}

}
