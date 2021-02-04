package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링_G5 {

	static int N, min = 987654321;
	static int[] populate;
	static int[][] map;
	static boolean[] group;
	
	public static int calculate() {
		
		int resA = 0, resB = 0;
		
		for(int i = 1; i <= N; i++) {
			if(group[i]) {
				resA += populate[i];
			} else {
				resB += populate[i];
			}
		}
		
		return Math.abs(resA - resB);
	}
	
	public static boolean isConnect(List<Integer> list, boolean tf) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(list.get(0));
		boolean[] visit = new boolean[N + 1];
		visit[list.get(0)] = true;
		
		// 연결된 선거구 수
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			for(int i = 1; i <= N; i++) {
				// 연결되어 있고, 방문하지 않았고, 그 선거구에 포함되었으면 큐에 추가
				if(map[n][i] == 1 && !visit[i] && group[i] == tf) {
					visit[i] = true;
					q.add(i);
					cnt++;
				}
			}
		}
		
		// bfs로 연결한 선거구 수와 list의 수가 같다면 참
		if(cnt == list.size()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	public static boolean check() {
		
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		
		// A선거구 B선거구 나누기
		for(int i = 1; i <= N; i++) {
			if(group[i]) {
				A.add(i);
			} else {
				B.add(i);
			}
		}
		
		// 선거구가 하나도 없으면
		if(A.size() == 0 || B.size() == 0) {
			return false;
		}
		
		// A선거구가 연결되어있지 않다면
		if(!isConnect(A, true)) {
			return false;
		}
		
		// B선거구가 연결되어있지 않다면
		if(!isConnect(B, false)) {
			return false;
		}
		
		return true;
	}
	
	public static void solve(int cnt, int start) {
		
		// 한 선거구가 최소 1개 이상이고, 선거구가 연결되어 있다면 선거인원 계산
		if(cnt > 0 && check()) {
			min = Math.min(min, calculate());
		}
		
		// 선거구 뽑기
		for(int i = start; i <= N; i++) {
			if(!group[i]) {
				group[i] = true;
				solve(cnt + 1, i);
				group[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		populate = new int[N + 1];
		map = new int[N + 1][N + 1];
		group = new boolean[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			populate[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			for(int j = 0; j < k; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][num] = 1;
				map[num][i] = 1;
			}
		}
		
		solve(0, 1);
		
		if(min == 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

}
