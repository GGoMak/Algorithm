package baekjoon;

import java.util.*;
import java.io.*;

public class baekjoon1072 {
	
	static long X, Y;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		int left = 0, right = 1000000000;
		long stand = (Y * 100) / X;
		int res = 0;
		
		if(stand >= 99) {
			System.out.println(-1);
			return;
		}
		
		while(left <= right) {
			
			int mid = (left + right) / 2;
			long t = ((Y + mid) * 100) / (X + mid);
			
			// 기존 승률 보다 추가된 승률이 더 작으면 승을 더 크게 해야함
			// 승률이 같을 때부터 left값을 올려가기기 때문에 mid는 승률이 같은 최대값이 될것 이고 거기에 +1을 하면 승률이 1퍼 바뀌게 됨
			if(stand >= t) {
				res = mid + 1;
				left = mid + 1;
			} 
			// 기존 승률 보다 추가된 승률이 더 크면 추가된 승을 더 작게해야함
			else if(stand < t) {
				right = mid - 1;
			}
		}
		
		System.out.println(res);
	}

}
