package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2243_사탕상자_P5 {

    static int N;
    static int[] tree;
    static StringBuilder sb = new StringBuilder();

    public static int query(int node, int start, int end, int mat) {

        tree[node]--;

        if(start == end) {
            return start;
        }

        if(tree[node * 2] >= mat) {
            return query(node * 2, start, (start + end) / 2, mat);
        } else {
            return query(node * 2 + 1, (start + end) / 2 + 1, end, mat - tree[node * 2]);
        }
    }

    public static void update(int node, int start, int end, int i, int j) {

        if(i < start || i > end) {
            return;
        }

        tree[node] += j;

        if(start != end) {
            update(node * 2, start, (start + end) / 2, i, j);
            update(node * 2 + 1, (start + end) / 2 + 1, end, i, j);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[4000001];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(A == 1) {
                sb.append(query(1, 1, 1000000, B)).append("\n");
            } else {
                int C = Integer.parseInt(st.nextToken());

                update(1, 1, 1000000, B, C);
            }
        }

        System.out.println(sb);
    }
}
