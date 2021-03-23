package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_16120_PPAP_G4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input = new StringBuilder(br.readLine());
		
		Stack<Character> s = new Stack<>();
		
		for(int i = 0; i < input.length(); i++) {
			if(s.size() > 1 && input.charAt(i) == 'A') {
				char p1 = s.pop();
				char p2 = s.pop();
				
				if(i + 1 < input.length() && input.charAt(i + 1) == 'P' && p1 == 'P' && p2 == 'P') {
					s.push('P');
					i++;
				} else {
					s.push(p2);
					s.push(p1);
				}
			} else {
				s.push(input.charAt(i));
			}
		}
		
		if(s.size() == 1) {
			char ch = s.pop();
			
			if(ch == 'P') {
				System.out.println("PPAP");
			} else {
				System.out.println("NP");
			}
		} else {
			System.out.println("NP");
		}
	}

}
