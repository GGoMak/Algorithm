package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수_G4 {

	static int N;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		Stack<Integer> s = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ans = new int[N];
		Arrays.fill(ans, -1);
		
		for (int i = 0; i < arr.length; i++) {
	        while(!s.empty() && arr[s.peek()] < arr[i]) {
	        	ans[s.peek()] = arr[i];
	            s.pop();
	        }
	        s.push(i);
	    }
		
		for(int i = 0; i < ans.length; i++) {
			sb.append(ans[i]).append(" ");
		}
		
		System.out.println(sb);
	}

}
