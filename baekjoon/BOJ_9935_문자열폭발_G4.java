package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발_G4 {

	static StringBuilder input;
	static StringBuilder bomb;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = new StringBuilder(br.readLine());
		bomb = new StringBuilder(br.readLine());
		
		char[] stack = new char[1000001];
		int top = 0;
		
		for(int i = 0; i < input.length(); i++) {
			stack[top++] = input.charAt(i);
			
			if(top >= bomb.length() && stack[top - 1] == bomb.charAt(bomb.length() - 1)) {
				int tempTop = top - 1;
				
				boolean check = true;
				
				for(int j = 1; j < bomb.length(); j++) {
					if(bomb.charAt(bomb.length() - 1 - j) != stack[--tempTop]) {
						check = false;
						break;
					}
				}
				
				if(check) {
					top = tempTop;
				}
			}
		}
		
		if(top == 0) {
			System.out.println("FRULA");
		} else {
			for(int i = 0; i < top; i++) {
				sb.append(stack[i]);
			}
			System.out.println(sb);
		}
	}

}
