package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌_S5 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int num = 666;
		int cnt = 0;
		
		while(true) {
			
			String temp = Integer.toString(num++);
			
			if(temp.contains("666")) {
				cnt++;
			}
			
			if(cnt == N) {
				num = Integer.parseInt(temp);
				break;
			}
		}
		
		System.out.println(num);

	}
}
