package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620_나는야포켓몬마스터이다솜_S4 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map1 = new HashMap<>();
		Map<Integer, String> map2 = new HashMap<>();
		for(int i = 1; i <= N; i++) {
			String input = br.readLine();
			map1.put(input, i);
			map2.put(i, input);
		}
		
		for(int i = 0; i < M; i++) {
			String question = br.readLine();
			
			if(Character.isDigit(question.charAt(0))) {
				sb.append(map2.get(Integer.parseInt(question))).append("\n");
			} else {
				sb.append(map1.get(question)).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
