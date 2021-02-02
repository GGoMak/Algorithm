package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
	
	static int K, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		
		// K값의 범위가 1이상이기 때문에 left는 1부터 시작(0부터 시작할 경우 mid가 0이 나올 수 있어서 divided 0 오류) 
		long left = 1, right = 0;
		
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(right < arr[i]) {
				right = arr[i];
			}
		}
		
		long mid = 0;	// 자를 랜선의 길이
		long result = 0;
		
		while(left <= right) {
			mid = (left + right) / 2;
			long cnt = 0;
			
			// mid길이로 자를 수 있는 랜선의 개수 구하기
			for(int i = 0; i < K; i++) {
				cnt += arr[i] / mid;
			}
			
			// 개수가 부족하면 더 짧게 잘라야함
			if(cnt < N) {
				right = mid - 1;
			} 
			// 개수가 크면 더 길게 잘라야 하고 같은 경우에는 최대값을 구하기 위해 더 길게 잘라봄(result에 현재의 최대값 저장)
			else {
				if(result < mid) {
					result = mid;
				}
				left = mid + 1;
			}
		}
		
		System.out.println(result);
	}

}
