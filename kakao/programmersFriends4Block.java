import java.util.Scanner;

public class programmersFriends4Block {
	
	static int[][] deltas = {{0, 1}, {1, 1}, {1, 0}};
	
	public static void main(String[] args) {
		int M, N;
		String[] board;
		
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		board = new String[M + 1];
		
		for(int i = 0; i < M; i++) {
			board[i] = sc.next();
		}
		
		System.out.println(solution(M, N, board));
	}
	
	public static int solution(int M, int N, String[] board) {
		int answer = 0;
		
		char[][] map = new char[M + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			map[i] = board[i].toCharArray();
		}
		
		while(true) {
			int cnt = erase(M, N, map);
			if(cnt == 0) {
				break;
			}
			sort(M, N, map);
			answer += cnt;
		}
		
		return answer;
	}
	
	public static int erase(int M, int N, char[][] board) {
		
		int res = 0;
		int[][] map = new int[M + 1][N + 1];
		
		// 지울 블럭 찾기
		for(int i = 0; i < M - 1; i++) {
			j : for(int j = 0; j < N - 1; j++) {
				char stand = board[i][j];
				
				if(stand == '0') {
					continue;
				}
				
				for(int k = 0; k < 3; k++) {
					int nx = i + deltas[k][0];
					int ny = j + deltas[k][1];
					
					if(board[nx][ny] != stand) {
						continue j;
					}
				}
				
				for(int k = 0; k < 3; k++) {
					int nx = i + deltas[k][0];
					int ny = j + deltas[k][1];
					
					map[nx][ny] = 1;
				}
				map[i][j] = 1;
			}
		}
		
		// 블럭 지우기
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					board[i][j] = '0';
					res++;
				}
			}
		}
		
		return res;
	}
	
	public static void sort(int M, int N, char[][] board) {
		for(int j = 0; j < N; j++) {
			i : for(int i = M - 1; i >= 0; i--) {
				if(board[i][j] == '0') {
					for(int k = i - 1; k >= 0; k--) {
						if(board[k][j] != '0') {
							board[i][j] = board[k][j];
							board[k][j] = '0';
							continue i;
						}
					}
				}
			}
		}
	}
}
