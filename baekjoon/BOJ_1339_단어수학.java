package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1339_단어수학 {

	static int N, max = 0;
	static int[] arr = new int[27];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			int mul = 1;
			
			// 가중치 초기화
			for(int j = str.length() - 1; j >= 0; j--) {
				arr[str.charAt(j) - 'A'] += mul;
				mul *= 10;
			}
		}
		
		List<Integer> list = new ArrayList<>();
		// 가중치 뽑아오기
		for(int i = 0; i < 26; i++) {
			if(arr[i] != 0) {
				list.add(arr[i]);
			}
		}
		
		// 역순 정렬
		Collections.sort(list, (o1, o2) -> (Integer.compare(o1, o2) * -1));
		int res = 0;
		
		// 가장 큰 가중치에 가장 큰 수 할당하고 연산
		for(int i = 9; i >= 0; i--) {
			res += list.get(0) * i;
			list.remove(0);
			if(list.isEmpty()) {
				break;
			}
		}
		
		System.out.println(res);
		
	}

}
