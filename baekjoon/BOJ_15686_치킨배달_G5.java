package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달_G5 {

	static int N, M;
	static int min = 987654321;
	static List<Point> chicken = new ArrayList<>();
	static List<Point> house = new ArrayList<>();
	
	public static int chickenDist(boolean[] survive) {
		
		int totalDist = 0;
		
		// 한 집에서 나머지 치킨집 까지의 거리중 가장 짧을 거리를 totalDist에 더함
		for(int i = 0; i < house.size(); i++) {
			int dist = 987654321;
			for(int j = 0; j < chicken.size(); j++) {
				if(survive[j]) {
					dist = Math.min(dist, Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y));
				}
			}
			totalDist += dist;
		}
		
		return totalDist;
	}
	
	public static void solve(int cnt, int start, boolean[] survive) {
		
		// 다 폐업 시켰으면 치킨거리 계산
		if(cnt == chicken.size() - M) {
			min = Math.min(min, chickenDist(survive));
			return;
		}
		
		// 폐업할 치킨집 뽑기
		for(int i = start; i < chicken.size(); i++) {
			survive[i] = false;
			solve(cnt + 1, i + 1, survive);
			survive[i] = true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				
				// 집의 좌표 등록
				if(t == 1) {
					house.add(new Point(i, j));
				}
				
				// 치킨집 좌표 등록
				else if(t == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}
		
		// 살아남은 치킨집 표시
		boolean[] survive = new boolean[chicken.size()];
		Arrays.fill(survive, true);
		solve(0, 0, survive);
		
		System.out.println(min);
	}

}
