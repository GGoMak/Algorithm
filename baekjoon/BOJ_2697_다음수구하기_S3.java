package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2697_다음수구하기_S3 {

	static int T;
	static StringBuilder result = new StringBuilder();
	
	public static StringBuilder solve(StringBuilder sb) {
		
		char last = sb.charAt(sb.length() - 1);
		int idx;
		
		// i + 1번째 수 보다 i번째 수 가 작은 경우를 찾음(뒤에서 부터 증가하다가 작아지는 수를 찾음)
		for(idx = sb.length() - 1; idx >= 0; idx--) {
			if(sb.charAt(idx) < last) {
				break;
			}
			last = sb.charAt(idx);
		}
		
		// 계속 증가하는 수이면 이보다 더 큰 수는 없으므로 null 리턴
		if(idx == -1) {
			return null;
		}

		// 작아지는 부분 앞에는 그대로 복사
		StringBuilder res = new StringBuilder();
		res.append(sb.substring(0, idx));
		
		// 자른 문자열을 탐색
		// idx + 1 부터 문자열 끝까지에서 idx번째 숫자 바로 다음으로 큰수를 찾음
		char min = '9';
		int minIdx = 0;
		
		for(int i = idx + 1; i < sb.length(); i++) {
			if(sb.charAt(idx) < sb.charAt(i)) {
				if(sb.charAt(i) < min) {
					min = sb.charAt(i);
					minIdx = i;
				}
			}
		}
		// 그 숫자가 idx번째에 들어올 숫자이므로 결과에 추가
		res.append(min);
		
		// 뒷 부분 문자열을 잘라서
		String temp = sb.substring(idx, sb.length());
		
		// 갯수를 세주고
		int[] num = new int[10];
		
		for(int i = 0; i < temp.length(); i++) {
			num[temp.charAt(i) - '0']++;
		}
		
		// idx번째에 붙인 숫자를 빼주고
		num[min - '0']--;
		
		// 작은 수부터 차례대로 결과에 붙여주면 다음 수가 나옴
		for(int i = 0; i < 10; i++) {
			while(num[i] > 0) {
				res.append(i);
				num[i]--;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append(br.readLine());
			
			StringBuilder res = (solve(sb));
			
			if(res == null) {
				result.append("BIGGEST\n");
			} else {
				result.append(res + "\n");
			}
		}
		
		System.out.println(result);

	}

}
