package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1_S4 {

	static int N, M, R;
	static int[][] arr;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 돌릴 범위 정하기
		int cnt = Math.min(N, M) / 2;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < cnt; j++) {
				int dir = 0;
				
				int indexX = j, indexY = j;
				int temp = arr[indexX][indexY];
				
				// 4방향으로 배열 땡기기
				while(dir < 4) {
					int nx = indexX + dx[dir];
					int ny = indexY + dy[dir];
					
					// 해당 범위를 벗어나면 방향 전환
					if(nx < j || ny < j || nx >= N - j || ny >= M - j) {
						dir++;
						continue;
					}
					
					// 해당 방향으로 배열 땡기기
					arr[indexX][indexY] = arr[nx][ny];
					indexX = nx;
					indexY = ny;
				}
				
				// 마지막 위치에 저장해놨던 수 덮어쓰기
				arr[j + 1][j] = temp;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
