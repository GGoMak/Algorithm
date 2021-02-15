package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식_S1 {

	static int N;
	static int[] sour;
	static int[] bitter;
	static long result = Long.MAX_VALUE;
	
	public static long calcul(ArrayList<Integer> arr) {
		
		long sourMul = 1;
		long bitterSum = 0;
		
		for(int i = 0; i < arr.size(); i++) {
			sourMul *= sour[arr.get(i)];
			bitterSum += bitter[arr.get(i)];
		}
		
		return Math.abs(sourMul - bitterSum);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		sour = new int[N];
		bitter = new int[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < (1 << N); i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) > 0) {
					temp.add(j);
				}
			}
			
			result = Math.min(result, calcul(temp));
		}
		
		System.out.println(result);
	}

}
