package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기_G5 {

	static int L, C;
	static char[] ch;
	static StringBuilder sb = new StringBuilder();
	
	public static boolean isPossible(char[] select) {
		
		int vowel = 0, conso = 0;
		
		for(int i = 0; i < select.length; i++) {
			if(select[i] == 'a' || select[i] == 'e' || select[i] == 'i' || select[i] == 'o' || select[i] == 'u'){
				vowel++;
			} else {
				conso++;
			}
		}
		
		if(vowel >= 1 && conso >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void solve(int cnt, char[] select, int startIdx) {
		
		if(cnt == L) {
			if(isPossible(select)) {
				sb.append(select).append("\n");
			}
			return;
		}
	
		for(int i = startIdx; i < C; i++) {
			select[cnt] = ch[i];
			solve(cnt + 1, select, i + 1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ch = new char[C];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < C; i++) {
			ch[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(ch);
		
		char[] selected = new char[L];
		solve(0, selected, 0);
		
		System.out.println(sb);
	}

}
