package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_보석도둑_G2 {
    static int N, K;

    static class Jewelry{
        int weight;
        int value;
        public Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Jewelry[] j = new Jewelry[N];
        int[] bag = new int[K];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            j[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(j, (o1, o2) -> {
        	return Integer.compare(o1.weight, o2.weight);
        });
        Arrays.sort(bag);

        long res = 0;
        int idx = 0;
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < K; i++){
        	
        	while(idx < N && j[idx].weight <= bag[i]) {
        		maxQ.add(j[idx++].value);
        	}
        	
        	if(!maxQ.isEmpty()) {
        		res += maxQ.poll();
        	}
        }

        System.out.println(res);
    }
}
