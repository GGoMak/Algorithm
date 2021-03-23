package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ_1935_후위표기식2_S3 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		Map<Character, Double> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			double num = Integer.parseInt(br.readLine());
			map.put((char)('A' + i), num);
		}
		
		Stack<Double> s = new Stack<>();
		
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			if(Character.isLetter(ch)) {
				s.push(map.get(ch));
			} else if(s.size() >= 2){
				double b = s.pop();
				double a = s.pop();
				
				if(ch == '+') {
					s.push(a + b);
				} else if(ch == '-') {
					s.push(a - b);
				} else if(ch == '/') {
					s.push(a / b);
				} else if(ch == '*') {
					s.push(a * b);
				}
			}
		}
		
		System.out.printf("%.2f\n", s.pop());
	}

}
