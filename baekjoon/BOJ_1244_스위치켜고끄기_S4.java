package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기_S4 {

	static int N, M;
	static boolean[] sw = new boolean[101];
	
	public static void man(int n) {
		for(int i = n; i <= N; i += n) {
			sw[i] = !sw[i];
		}
	}
	
	public static void woman(int n) {
		
		sw[n] = !sw[n];
		
		for(int i = 1; i < N; i++) {
			
			if(n + i > N || n - i <= 0) {
				break;
			}
			
			if(sw[n + i] != sw[n - i]) {
				break;
			}
			
			sw[n + i] = !sw[n + i];
			sw[n - i] = !sw[n - i];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			if(st.nextToken().equals("1")) {
				sw[i] = true;
			} else {
				sw[i] = false;
			}
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 남자라면
			if(st.nextToken().equals("1")) {
				man(Integer.parseInt(st.nextToken()));
			}
			// 여자라면
			else {
				woman(Integer.parseInt(st.nextToken()));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			if(sw[i]) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
			if(i % 20 == 0) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
