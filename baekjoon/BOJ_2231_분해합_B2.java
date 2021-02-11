package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2231_분해합_B2 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		N = Integer.parseInt(temp);
		
		int result = 0;
		
		// 자리수 * 9가 분해합으로 더할 수 있는 최대 수 이므로
		// N - 자리수 * 9부터 검사하면 최적화 가능
		for(int i = N - (temp.length() * 9); i < N; i++) {
			int sum = i;	// 더할 수
			int num = i;	// 나눌 수
			
			// 가장 오른쪽 수 부터 더해감
			while(num > 0) {
				sum += num % 10;
				num /= 10;
			}
			
			// 나온 분해합이 N이면 결과값 출력
			if(sum == N) {
				result = i;
				break;
			}
			
		}
		
		System.out.println(result);
	}

}
