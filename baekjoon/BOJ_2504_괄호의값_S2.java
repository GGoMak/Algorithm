package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504_괄호의값_S2 {

	static boolean error = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input = new StringBuilder(br.readLine());

		Stack<String> s = new Stack<>();
		
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			// ), ]이 들어왔을때 스택이 비어 있으면 에러
			if(ch == ')' || ch == ']') {
				if(s.size() == 0) {
					System.out.println("0");
					return;
				}
			}
			
			// (, [이 들어오면 스택에 push
			if(ch == '(' || ch == '[') {
				s.push(Character.toString(ch));
			} 
			
			else if(ch == ')') {
				String top = s.peek();
				
				// 스택의 top이 맞는 괄호이면 숫자로 변환하고 스택에  push
				if(top.equals("(")) {
					s.pop();
					s.push("2");
				} 
				// 올바르지 않은 괄호이면 에러
				else if(top.equals(")") || top.equals("[") || top.equals("]")) {
					System.out.println("0");
					return;
				} 
				// 숫자이면
				else {
					int sum = 0;
					
					// 맞는 괄호를 만날때 까지 pop하면서 스택에 있는 숫자를 다 더해줌
					while(s.size() > 0 && !s.peek().equals("(")) {
						if(s.peek().equals(")") || s.peek().equals("[") || s.peek().equals("]")) {
							System.out.println("0");
							return;
						}
						sum += Integer.parseInt(s.pop());
					}
					
					// 맞는 괄호가 없어서 스택이 0이 되면 에러
					if(s.size() == 0) {
						System.out.println("0");
						return;
					}
					
					s.pop();
					s.push(Integer.toString(sum * 2));
				}
			} 
			
			else if(ch == ']') {
				String top = s.peek();
				
				// 스택의 top이 맞는 괄호이면 숫자로 변환하고 스택에  push
				if(top.equals("[")) {
					s.pop();
					s.push("3");
				} 
				// 올바르지 않은 괄호이면 에러
				else if(top.equals("]") || top.equals("(") || top.equals(")")) {
					System.out.println("0");
					return;
				} 
				// 숫자이면
				else {
					int sum = 0;
					
					// 맞는 괄호를 만날때 까지 pop하면서 스택에 있는 숫자를 다 더해줌
					while(s.size() > 0 && !s.peek().equals("[")) {
						if(s.peek().equals("]") || s.peek().equals("(") || s.peek().equals(")")) {
							System.out.println("0");
							return;
						}
						sum += Integer.parseInt(s.pop());
					}
					
					// 맞는 괄호가 없어서 스택이 0이 되면 에러
					if(s.size() == 0) {
						System.out.println("0");
						return;
					}
					
					s.pop();
					s.push(Integer.toString(sum * 3));
				}
			}
		}
		
		// 결과로 나온 스택이 비어있으면 에러
		if(s.size() == 0) {
			System.out.println(0);
		} else {
			int result = 0;

			while(s.size() > 0) {
				// 결과로 나온 스택에는 숫자만 있어야 함
				if(s.peek().equals("[") || s.peek().equals("]") || s.peek().equals("(") || s.peek().equals(")")) {
					System.out.println("0");
					return;
				}
				
				result += Integer.parseInt(s.pop());
			}
			
			System.out.println(result);
		}
	}

}
