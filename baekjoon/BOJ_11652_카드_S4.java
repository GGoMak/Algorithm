package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BOJ_11652_카드_S4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<Long, Long> m = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			long n = Long.parseLong(br.readLine());
			
			if(m.containsKey(n)) {
				m.replace(n, m.get(n) + 1);
			} else {
				m.put(n, (long)1);
			}
		}
		
		long num = 0;
		long value = 0;
		
		for(Map.Entry<Long, Long> entry : m.entrySet()) {
			if(value < entry.getValue()) {
				value = entry.getValue();
				num = entry.getKey();
			} else if(value == entry.getValue()) {
				if(num > entry.getKey()) {
					num = entry.getKey();
				}
			}
		}
		
		System.out.println(num);
	}

}
