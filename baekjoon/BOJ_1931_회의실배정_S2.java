package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정_S2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Point[] p = new Point[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			p[i] = new Point(x, y);
		}
		
		Arrays.sort(p, (o1, o2) -> {
			if(o1.y != o2.y) {
				return Integer.compare(o1.y, o2.y);
			} else {
				return Integer.compare(o1.x, o2.x);
			}
		});
		
		int time = p[0].y;
		
		int cnt = 1;
		
		for(int i = 1; i < N; i++) {
			if(p[i].x >= time) {
				time = p[i].y;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
