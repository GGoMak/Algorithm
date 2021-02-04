package baekjoon1062;

import java.io.*;
import java.util.*;

public class BOJ_1062_가르침_G4 {
	
	static int N, K;
	static ArrayList<ArrayList<Integer>> combi = new ArrayList<ArrayList<Integer>>();
	
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	    	ArrayList<Integer> t = new ArrayList<Integer>();
	    	for(int i = 0; i < visited.length; i++) {
	    		if(visited[i]) {
	    			t.add(i);
	    		}
	    	}
	    	t.add('a' - 'a');
	    	t.add('n' - 'a');
	    	t.add('t' - 'a');
	    	t.add('c' - 'a');
	    	t.add('i' - 'a');
	    	combi.add(t);
	        return;
	    } 

	    for(int i = start; i < n; i++) {
	    	if(i == 'a' - 'a' || i == 'n' - 'a' || i == 't' - 'a' || i == 'c' - 'a' || i == 'i' - 'a') {
	    		continue;
	    	}
	    	
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		StringBuilder[] sbs = new StringBuilder[N];
				
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			sbs[i] = sb;
		}
		
		boolean[] visit = new boolean[26];
		int[] arr = new int[26];
		for(int i = 0; i < 26; i++) {
			arr[i] = i;
		}
		combination(arr, visit, 0, 26, K - 5);
		
		for(int k = 0; k < combi.size(); k++) {
			int result = 0;
			i : for(int i = 0; i < N; i++) {
				for(int j = 4; j < sbs[i].length() - 4; j++) {
					if(!combi.get(k).contains((int)sbs[i].charAt(j) - 'a')) {
						continue i;
					}
				}
				result++;
			}
			max = Math.max(max, result);
		}
		
		System.out.println(max);
	}
}
