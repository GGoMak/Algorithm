import java.util.Scanner;

public class BOJ_17779_게리맨더링2_G4 {
	
	static int N, total;
	static int one, two, three, four, five;
	static int[][] A;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		A = new int[N + 2][N + 2];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				A[i][j] = sc.nextInt();
				total += A[i][j];
			}
		}
		
		int max = 0, min = 987654321;
		int result = 987654321;
		
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= N; y++) {
				for(int d1 = 1; d1 <= N; d1++) {
					for(int d2 = 1; d2 <= N; d2++) {
						
						if(x == 1 && (y == d1 || N - y == d2)){
							continue;
						}
						if(y - d1 == 1 && x + d1 + d2 == N) {
							continue;
						}
						if(y + d2 == N && x + d2 + d1 == N) {
							continue;
						}
						
						int[][] area = new int[N + 2][N + 2];
						
						divide(area, x, y, d1, d2);
						area[x][y] = 5;
						
						setOne(area, x, y, d1, d2);
						setTwo(area, x, y, d1, d2);
						setThree(area, x, y, d1, d2);
						setFour(area, x, y, d1, d2);
						
						for(int i = 1; i <= N; i++) {
							for(int j = 1; j <= N; j++) {
								if(area[i][j] == 1) {
									one += A[i][j];
								}
								else if(area[i][j] == 2) {
									two += A[i][j];
								}
								else if(area[i][j] == 3) {
									three += A[i][j];
								}
								else if(area[i][j] == 4) {
									four += A[i][j];
								}
								else {
									five += A[i][j];
								}
							}
						}
						
						max = Math.max(one, Math.max(two, Math.max(three, Math.max(four, five))));
						min = Math.min(one, Math.min(two, Math.min(three, Math.min(four, five))));
						
						result = Math.min(result, max - min);
						one = 0;
						two = 0;
						three = 0;
						four = 0;
						five = 0;
					}
				}
			}
		}
		
		System.out.println(result);
	}
	
	static void setOne(int[][] area, int x, int y, int d1, int d2) {
		for(int i = 1; i < x + d1; i++) {
			for(int j = 1; j <= y; j++) {
				if(!isIn(i, j)) {
					continue;
				}
				
				if(area[i][j] == 5) {
					break;
				}
				area[i][j] = 1;
			}
		}
	}
	
	static void setTwo(int[][] area, int x, int y, int d1, int d2) {
		for(int i = 1; i <= x + d2; i++) {
			for(int j = N; j > y; j--) {
				if(!isIn(i, j)) {
					continue;
				}
				if(area[i][j] == 5) {
					break;
				}
				area[i][j] = 2;
			}
		}
	}
	
	static void setThree(int[][] area, int x, int y, int d1, int d2) {
		for(int i = x + d1; i <= N; i++) {
			for(int j = 1; j < y - d1 + d2; j++) {
				if(!isIn(i, j)) {
					continue;
				}
				if(area[i][j] == 5) {
					break;
				}
				area[i][j] = 3;
			}
		}
	}
	
	static void setFour(int[][] area, int x, int y, int d1, int d2) {
		for(int i = x + d2 + 1; i <= N; i++) {
			for(int j = N; j >= y - d1 + d2; j--) {
				if(!isIn(i, j)) {
					continue;
				}
				if(area[i][j] == 5) {
					break;
				}
				area[i][j] = 4;
			}
		}
	}
	
	static void divide(int[][] area, int x, int y, int d1, int d2) {
		
		for(int i = 1; i <= d1; i++) {
			if(isIn(x + i, y - i)) {
				area[x + i][y - i] = 5;
			}
		}
		
		for(int i = 1; i <= d2; i++) {
			if(isIn(x + i, y + i))
				area[x + i][y + i] = 5;
		}
		
		for(int i = 1; i <= d2; i++) {
			if(isIn(x + d1 + i, y - d1 + i)) {
				area[x + d1 + i][y - d1 + i] = 5;
			}
		}
		
		for(int i = 1; i <= d1; i++) {
			if(isIn(x + d2 + i, y + d2 - i)) {
				area[x + d2 + i][y + d2 - i] = 5;
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return 1 <= x && x <= N && 1 <= y && y <= N;
	}
}
