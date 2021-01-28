package baekjoon2775;

import java.io.*;

public class baekjoon2775 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] apt = new int[16][16];
		
		for(int i = 0; i < 16; i++) {
			apt[0][i] = i;
		}
		
		for(int i = 1; i <= 14; i++) {
			for(int j = 1; j <= 14; j++) {
				if(apt[i][j] == 0) {
					apt[i][j] = apt[i][j -1] + apt[i - 1][j];
				}
			}
		}
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < test_case; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(apt[k][n]);
		}
	}
}
