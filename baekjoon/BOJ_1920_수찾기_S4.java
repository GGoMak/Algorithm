package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기_S4 {
	
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> n = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			n.add(Integer.parseInt(st.nextToken()));
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(n.contains(num)){
				res.append("1\n");
			} else {
				res.append("0\n");
			}
		}
		
		System.out.println(res);
	}
}
