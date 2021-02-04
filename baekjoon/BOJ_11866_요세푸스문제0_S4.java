package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ_11866_요세푸스문제0_S4 {
	
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		List<Integer> arr = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			arr.add(i);
		}
		
		List<Integer> res = new ArrayList<>();
		int index = K - 1;
		while(arr.size() > 0) {
			
			while(index > arr.size() - 1) {
				index -= arr.size();
			}
			
			
			res.add(arr.get(index));
			arr.remove(index);
			index--;
			index += K;
		}
		
		bw.write("<");
		for(int i = 0; i < res.size() - 1; i++) {
			bw.write(res.get(i) + ", ");
		}
		bw.write(res.get(res.size() - 1) + "");
		bw.write(">");
		bw.flush();
	}

}
