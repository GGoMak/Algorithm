package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1300_K번째수_G3 {

	static int N, K;
    static long result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long left = 1, right = K;

        while(left <= right) {
            long cnt = 0;
            long mid = (left + right) / 2;

            for(int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if(cnt < K) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
	
}
