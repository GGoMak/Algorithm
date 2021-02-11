package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5525_IOIOI_S2_1 {

	static int N, M;
	static String S;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();
		
		int result = 0;
		
		for(int i = 0; i < M - 2; i++) {
			int cnt = 0;
			
			// I가 나오고 그 다음으로 나오는 OI를 갯수를 세어줌
			if(S.charAt(i) == 'I') {
				while(S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
					cnt++;
					i += 2;
					
					// OI의 개수가  N이상이면 result++
					if(cnt >= N) {
						result++;
					}
					
					// i가 문자열의 길이를 넘어가면 반복문 탈출(예외처리)
					if(i >= M - 2) {
						break;
					}
				}
			}
		}
		
		System.out.println(result);
		
	}

}