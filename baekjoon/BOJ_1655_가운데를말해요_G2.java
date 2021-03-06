package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1655_가운데를말해요_G2 {
	static int N;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minQ = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(maxQ.size() == 0) {
                maxQ.add(num);
            } else {
                if(maxQ.size() - 1 == minQ.size()) {
                    minQ.add(num);
                } else {
                    maxQ.add(num);
                }

                if(maxQ.peek() > minQ.peek()) {
                    int temp = maxQ.poll();
                    maxQ.add(minQ.peek());
                    minQ.poll();
                    minQ.add(temp);
                }

            }

            sb.append(maxQ.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
