package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5525_IOIOI_S2 {

	static int N, M;
	static String S;
	static int[] arr; // i번째 문자열 까지의 IOI 길이를 담는 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();
		arr = new int[M + 1];
		
		// 문자열 탐색
		for(int i = 2; i < M; i++) {
			
			
			if(S.charAt(i) == 'O') {
				// OO가 나오면 0으로 초기화
				if(S.charAt(i - 1) == 'O') {
					arr[i] = 0;
				} 
				// O가 나오면 이전의 값 그대로 가져옴
				else {
					arr[i] = arr[i - 1];
				}
			} else if(S.charAt(i) == 'I') {
				// i번째가 i일떄 이전 2개를 검사해서 IO이면 arr배열에 +1 값 추가
				if(S.charAt(i - 2) == 'I' && S.charAt(i - 1) == 'O' && S.charAt(i) == 'I') {
					arr[i] = arr[i - 2] + 1;
				} 
				// IOI가 아닌 경우에는 0으로 초기화
				else {
					arr[i] = 0;
				}
			} 
		}
		
		int cnt = 0;
		
		// arr배열에서 N이상인 숫자를 찾아서 결과값 +1
		for(int i = 2; i < M; i++) {
			if(arr[i] >= N) {
				cnt++;
				i++;
			}
		}
		
		System.out.println(cnt);
		
	}

}
