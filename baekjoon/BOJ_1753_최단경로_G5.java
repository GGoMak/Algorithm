package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로_G5 {

	static int V, E, K;
	static List<Point> map[];
	static int INF = 987654321;
	static StringBuilder sb = new StringBuilder();
	
	static class Node implements Comparable<Node>{
		int to, weight;
		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		map = new ArrayList[V + 1];
		
		for(int i = 0; i <= V; i++) {
			map[i] = new ArrayList<>();
		}

		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[from].add(new Point(to, w));
		}
		
		dijkstra(K);
		
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		boolean[] visit = new boolean[V + 1];
		int[] dist = new int[V + 1];
		
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int to = pq.peek().to;
			int weight = pq.peek().weight;
			pq.poll();
			
			if(!visit[to]) {
				visit[to] = true;
				
				for(int i = 0; i < map[to].size(); i++) {
					int nto = map[to].get(i).x;
					int nw = map[to].get(i).y;
					
					if(!visit[nto] && dist[nto] > dist[to] + nw) {
						dist[nto] = dist[to] + nw;
						pq.add(new Node(nto, dist[nto]));
					}
				}
			}
		}
		
		for(int i = 1; i < dist.length; i++) {
			if(dist[i] == INF) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}
	}

}
