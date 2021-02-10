package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3_S3 {

	static int N, M, R;
	static int[][] arr;
	
	public static void one() {
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N - 1 - i][j];
				arr[N - 1 - i][j] = temp;
			}
		}
	}
	
	public static void two() {
		for(int i = 0; i < M / 2; i++) {
			for(int j = 0; j < N; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[j][M - 1 - i];
				arr[j][M - 1 - i] = temp;
			}
		}
	}
	
	public static void three() {
		
		int[][] temp = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N ; j++) {
				temp[i][j] = arr[N - 1 - j][i];
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}
	
	public static void four() {
		int[][] temp = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N ; j++) {
				temp[i][j] = arr[j][M - 1 - i];
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}
	
	public static void five() {
		
		int[][] tarr = new int[N / 2][M / 2];
		
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M / 2; j++) {
				tarr[i][j] = arr[i][j];
			}
		}
		
		// 4 -> 1
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M / 2; j++) {
				arr[i][j] = arr[i + N / 2][j];
			}
		}
		
		// 3 -> 4
		for(int i = N / 2; i < N; i++) {
			for(int j = 0; j < M / 2; j++) {
				arr[i][j] = arr[i][j + M / 2];
			}
		}
		
		// 2 -> 3
		for(int i = N / 2; i < N; i++) {
			for(int j = M / 2; j < M; j++) {
				arr[i][j] = arr[i - N / 2][j];
			}
		}
		
		// 1 -> 2;
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M / 2; j++) {
				arr[i][j + M / 2] = tarr[i][j];
			}
		}
	}
	
	public static void six() {
		
		int[][] tarr = new int[N / 2][M / 2];
		
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M / 2; j++) {
				tarr[i][j] = arr[i][j];
			}
		}
		
		// 2 -> 1
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M / 2; j++) {
				arr[i][j] = arr[i][j + M / 2];
			}
		}
		
		// 3 -> 2
		for(int i = 0; i < N / 2; i++) {
			for(int j = M / 2; j < M; j++) {
				arr[i][j] = arr[i + N / 2][j];
			}
		}
		
		// 4 -> 3
		for(int i = N / 2; i < N; i++) {
			for(int j = M / 2; j < M; j++) {
				arr[i][j] = arr[i][j - M / 2];
			}
		}
		
		// 1 -> 4;{
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M / 2; j++) {
				arr[i + N / 2][j] = tarr[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[100][100];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int t = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			int operator = Integer.parseInt(st.nextToken());
			
			switch(operator) {
				case 1:
					one();
					break;
				case 2:
					two();
					break;
				case 3:
					three();
					t = N;
					N = M;
					M = t;
					break;
				case 4:
					four();
					t = N;
					N = M;
					M = t;
					break;
				case 5:
					five();
					break;
				case 6:
					six();
					break;
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
