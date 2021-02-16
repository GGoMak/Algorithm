package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈_S1 {

	static long C;
	
	public static long pow(long a, long b) {
		if(b == 0) {
			return 1;
		}
		
		long n = pow(a, b / 2);
		long temp = n * n % C;
		
		if(b % 2 == 0) {
			return temp;
		} else {
			return temp * a % C;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(A, B));
	}

}
