package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3613_JavavsC_S5 {
	
	static boolean c = false;
	static boolean java = false;
	static String sb;
	
	public static StringBuilder changeToJava() {
		StringBuilder res = new StringBuilder();
		
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == '_') {
				res.append((char)(sb.charAt(i + 1) - ('a' - 'A')));
				i++;
			} else {
				res.append(sb.charAt(i));
			}
		}
		
		return res;
	}
	
	public static StringBuilder changeToC() {
		StringBuilder res = new StringBuilder();
		
		for(int i = 0; i < sb.length(); i++) {
			if('A' <= sb.charAt(i) && sb.charAt(i) <= 'Z') {
				res.append("_" + (char)(sb.charAt(i) + ('a' - 'A')));
			} else {
				res.append(sb.charAt(i));
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = br.readLine();
		StringBuilder res = new StringBuilder();
		
		// 첫글자가 대문자이면 에러
		if('A' <= sb.charAt(0) && sb.charAt(0) <= 'Z') {
			System.out.println("Error!");
			return;
		}
		
		// 첫글자가 _ 이거나 마지막 글자가 _이면 에러
		if(sb.charAt(0) == '_' || sb.charAt(sb.length() - 1) == '_') {
			System.out.println("Error!");
			return;
		}
		
		// _가 연속으로 나오면 에러
		for(int i = 0; i < sb.length() - 1; i++) {
			if(sb.charAt(i) == '_' && sb.charAt(i + 1) == '_') {
				System.out.println("Error!");
				return; 
			}
		}
		
		// c++인데 대문자가 나오면 에러
		if(sb.contains("_")) {
			for(int i = 0; i < sb.length(); i++) {
				if('A' <= sb.charAt(i) && sb.charAt(i) <= 'Z') {
					System.out.println("Error!");
					return;
				}
			}
			
			System.out.println(changeToJava());
		} 
		// 자바 인데 _가 나오면 에러
		else {
			for(int i = 0; i < sb.length(); i++) {
				if(sb.charAt(i) == '_') {
					System.out.println("Error");
					return;
				}
			}
			
			System.out.println(changeToC());
		}
	}

}
