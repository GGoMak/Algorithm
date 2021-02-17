package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7453_합이0인네정수_G2 {

	static int N;
	static int[] A, B, C, D;
	static long[] arr1, arr2;
	
	public static int upperBound(long num) {
		
		int start = 0, end = N * N;
		
		while(start < end) {
			int mid = (start + end) / 2;
			if(arr2[mid] <= num) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		return end;
	}
	
	public static int lowerBound(long num) {
		
		int start = 0, end = N * N;
		
		while(start < end) {
			int mid = (start + end) / 2;
			if(arr2[mid] < num) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		return end;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		arr1 = new long[N * N];
		arr2 = new long[N * N];
		
		int index = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr1[index] = A[i] + B[j];
				arr2[index] = C[i] + D[j];
				index++;
			}
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int res = 0;
		
		for(int i = 0; i < index; i++) {
			long num = arr1[i] * -1;
			
			int upper = upperBound(num);
			int lower = lowerBound(num);
			
			res += upper - lower;
		}
		
		System.out.println(res);
	}

}
