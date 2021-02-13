package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형_S2 {

    static int N;
    static int[] input;
    static int maxHeight = 0, maxIdx = 0;
    static int lastIdx = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = new int[1001];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            input[idx] = height;

            if(maxHeight < height){
                maxHeight = height;
                maxIdx = idx;
            }

            if(lastIdx < idx){
                lastIdx = idx;
            }
        }

        int sum = 0;
        int tempHeight = 0;

        for(int i = 0; i <= maxIdx; i++){
            if(tempHeight < input[i]){
                tempHeight = input[i];
            }
            sum += tempHeight;
        }

        tempHeight = 0;
        for(int i = lastIdx; i > maxIdx; i--) {
            if(tempHeight < input[i]) {
                tempHeight = input[i];
            }

            sum += tempHeight;
        }

        System.out.println(sum);
    }
}
