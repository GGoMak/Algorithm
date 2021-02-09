package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기_G4 {

	static int N;
	static int[] max;
	static int[] min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		max = new int[3];
		min = new int[3];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[] tmax = {max[0], max[1], max[2]};
			int[] tmin = {min[0], min[1], min[2]};
			
			max[0] = Math.max(tmax[0], tmax[1]) + a;
			max[1] = Math.max(tmax[0], Math.max(tmax[1], tmax[2])) + b;
			max[2] = Math.max(tmax[1], tmax[2]) + c;
			min[0] = Math.min(tmin[0], tmin[1]) + a;
			min[1] = Math.min(tmin[0], Math.min(tmin[1], tmin[2])) + b;
			min[2] = Math.min(tmin[1], tmin[2]) + c;
		}
		
		int maxres = 0, minres = 987654321;
		
		maxres = Math.max(max[0], Math.max(max[1], max[2]));
		minres = Math.min(min[0], Math.min(min[1], min[2]));
		
		System.out.println(maxres + " " + minres);
		
	}

}
