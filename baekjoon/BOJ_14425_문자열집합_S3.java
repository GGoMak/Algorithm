package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_14425_문자열집합_S3 {

	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 집합 S를 담을 set자료구조
		Set<String> s = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			s.add(br.readLine());
		}
		
		int result = 0;
		
		// set에 포함되어있는지 검사
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			
			if(s.contains(str)) {
				result++;
			}
		}
		
		System.out.println(result);
	}

}
