package baekjoon;

import java.io.*;
import java.util.*;

public class baekjoon10814_1 {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringBuilder[] sb = new StringBuilder[201];
		
		for(int i = 1; i < 201; i++) {
			sb[i] = new StringBuilder();
		}
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int age = Integer.parseInt(st.nextToken());
			
			sb[age].append(str + "\n");
		}
		
		StringBuilder result = new StringBuilder();
		
		for(int i = 1; i < 201; i++) {
			result.append(sb[i]);
		}
		
		System.out.println(result);

	}

}
