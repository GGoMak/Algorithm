package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_6588_골드바흐의추측 {

	static int MAX = 1000000;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] isPrime = new boolean[MAX + 1];
		
		for(int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }
        for(int i = 2; i <= MAX; i++) {
            for(int j = i * 2; j <= MAX; j += i) {
                if(!isPrime[j]) continue;
                isPrime[j] = false;
            }
        }
		
		int num = 0;
		while((num = Integer.parseInt(br.readLine())) != 0) {
			
			for(int i = 2; i <= num / 2; i++) {
				if(isPrime[i] && isPrime[num - i]) {
					sb.append(num).append(" = ").append(i).append(" + ").append(num - i).append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
	}

}
