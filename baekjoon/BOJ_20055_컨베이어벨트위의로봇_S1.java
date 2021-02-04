package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇_S1 {

	static int N, K;
	static int[] belt;
	static boolean[] robot;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[N * 2];
		robot = new boolean[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N * 2; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		
		while(true) {
			
			// 단계 카운트
			result++;
			
			// 벨트 회전
			int temp = belt[N * 2 - 1];
			for(int i = N * 2 - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
				
				// 로봇도 같이 이동
				if(i < N && robot[i - 1]) {
					robot[i] = true;
					robot[i - 1] = false;
				}
			}
			belt[0] = temp;
			
			// 벨트 회전 후 로봇 내리기
			robot[N - 1] = false;
			
			// 로봇 이동 및 내구도 감소
			for(int i = N - 1; i > 0; i--) {
				if(!robot[i] && robot[i - 1] && belt[i] > 0) {
					robot[i - 1] = false;
					robot[i] = true;
					belt[i]--;
				}
			}
			
			// 로봇 올리기
			if(belt[0] > 0 && !robot[0]) {
				robot[0] = true;
				belt[0]--;
			}
			
			// 로봇 내리기
			if(robot[N - 1]) {
				robot[N - 1] = false;
			}
			
			int kCnt = 0;
			
			// 내구도가 0인 칸 check
			for(int i = 0; i < N * 2; i++) {
				if(belt[i] == 0) {
					kCnt++;
				}
			}
			
			if(kCnt >= K) {
				break;
			}
		}
		
		System.out.println(result);
		
	}

}
