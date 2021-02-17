package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2143_두배열의합_G3 {

	static long T;
	static int N, M;
	static long[] A, B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		A = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		B = new long[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Long> a = new ArrayList<>();
		ArrayList<Long> b = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			long sum = A[i];
			a.add(sum);
			for(int j = i + 1; j < N; j++) {
				sum += A[j];
				a.add(sum);
			}
		}
		
		for(int i = 0; i < M; i++) {
			long sum = B[i];
			b.add(sum);
			for(int j = i + 1; j < M; j++) {
				sum += B[j];
				b.add(sum);
			}
		}
		
		Map<Long, Integer> m = new HashMap<>();
		
		for(int i = 0; i < b.size(); i++) {
			if(m.containsKey(b.get(i))) {
				m.replace(b.get(i), m.get(b.get(i)) + 1);
			} else {
				m.put(b.get(i), 1);
			}
		}
		
		long res = 0;
		
		for(int i = 0; i < a.size(); i++) {
			long num = T - a.get(i);
			
			if(m.containsKey(num)) {
				res += m.get(num);
			}
		}
		
		System.out.println(res);
		
	}

}
