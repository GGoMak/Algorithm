package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ_2805_나무자르기_S3 {
	
	static int N, M;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		long[] tree = new long[1000001];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int t = Integer.parseInt(st2.nextToken());
			if(max < t) {
				max = t;
			}
			tree[i] = t;
		}
		
		long left = 0, right = max, mid;
		long result = 0;
		
		while(left <= right) {
			long log = 0;
			mid = (left + right) / 2;
			
			for(int i = 0 ; i < tree.size(); i++) {
				if(tree.get(i) > mid) {
					log += (tree.get(i) - mid);
				}
			}
			
			if(log >= M) {
				if(result < mid) {
					result = mid;
				}
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(result);
		
	}
}
