package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20056_마법사상어와파이어볼_G5 {

	static int N, M, K;
	static ArrayList<Node>[][] map;
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static class Node{
		int m, s, d;
		Node(int m, int s, int d){
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	public static void check() {
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j].size() >= 2) {
					int weightSum = 0;
					int speedSum = 0;
					int oddCnt = 0, evenCnt = 0;
					
					for(int k = 0; k < map[i][j].size(); k++) {
						weightSum += map[i][j].get(k).m;
						speedSum += map[i][j].get(k).s;
						
						if(map[i][j].get(k).d % 2 == 0) {
							evenCnt++;
						} else {
							oddCnt++;
						}
					}
					
					map[i][j].clear();
					
					if(weightSum >= 5) {
						int plusDir = 1;
						if(evenCnt == 0 || oddCnt == 0) {
							plusDir = 0;
						}
						
						for(int k = plusDir; k < 8; k += 2) {
							map[i][j].add(new Node(weightSum / 5, speedSum / (oddCnt + evenCnt), k));
						}
					}
				}
			}
		}
	}
	
	public static void move() {
		
		ArrayList<Node>[][] newMap = new ArrayList[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				newMap[i][j] = new ArrayList<Node>();
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				
				if(map[i][j].size() > 0) {
					for(int k = 0; k < map[i][j].size(); k++) {
						int nx = i + (map[i][j].get(k).s * dx[map[i][j].get(k).d]);
						int ny = j + (map[i][j].get(k).s * dy[map[i][j].get(k).d]);
						
						if(nx <= 0) {
							nx = N + (nx % N);
						}
						if(ny <= 0) {
							ny = N + (ny % N);
						}
						if(nx > N) {
							nx = (nx - 1) % N + 1;
						}
						if(ny > N) {
							ny = (ny - 1) % N + 1;
						}
						
						newMap[nx][ny].add(map[i][j].get(k));
					}
				}
			}
		}
		
		map = newMap.clone();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				map[i][j] = new ArrayList<Node>();
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			map[x][y].add(new Node(m, s, d));
		}
		
		for(int i = 0; i < K; i++) {
			move();
			check();
		}
		
		int sum = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j].size() > 0) {
					for(int k = 0; k < map[i][j].size(); k++) {
						sum += map[i][j].get(k).m;
					}
				}
			}
		}
		
		System.out.println(sum);
	}

}
