package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20304_비밀번호제작_G1 {

	static int N, M;
	static int[] arr;
	
	public static int bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[N + 1];
		
		for(int i = 0; i < arr.length; i++) {
			q.add(arr[i]);
			visit[arr[i]] = true;
		}
		
		int cnt = -1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			
			// 깊이 단위로 탐색
			while(size-- > 0) {
				int n = q.poll();
				
				// 1 ~ N 까지 비트 자리 단위로 탐색
				for(int i = 1; i <= N; i <<= 1) {
					// 비트를 바꿈으로써 안전거리 1씩 증가
					int next = n ^ i;
					
					// 비트를 바꾼 숫자가 N 범위 안에 있고 방문하지 않았으면 큐에 삽입
					if(next <= N && !visit[next]) {
						visit[next] = true;
						q.add(next);
					}
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bfs());
	}

}
