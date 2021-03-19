package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1735_분수합_S2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int lcmNum = lcm(b, d);
		
		int numerator = a * (lcmNum / b) + c * (lcmNum / d);
		int denumerator = lcmNum;
		
		int gcdNum = gcd(numerator, denumerator);
		
		if(gcdNum != 1) {
			System.out.println(numerator / gcdNum + " " + denumerator / gcdNum);
		} else {
			System.out.println(numerator + " " + denumerator);
		}
	}
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
	
	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

}
