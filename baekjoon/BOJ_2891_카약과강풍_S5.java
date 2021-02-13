package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2891_카약과강풍_S5 {

    static int N, S, R;
    static boolean[] spare;
    static boolean[] damaged;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());


        spare = new boolean[N + 1];
        damaged = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < S; i++){
            damaged[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < R; i++){
            spare[Integer.parseInt(st.nextToken())] = true;
        }

        for(int i = 1; i <= N; i++){
            if(damaged[i]){
                if(i == 1){
                    if(spare[i + 1]){
                        spare[i + 1] = false;
                        damaged[i] = false;
                        continue;
                    }
                }

                else if(i == N){
                    if(spare[i - 1]){
                        spare[i - 1] = false;
                        damaged[i] = false;
                        continue;
                    }
                }

                else {
                    if (spare[i - 1]) {
                        spare[i - 1] = false;
                        damaged[i] = false;
                        continue;
                    }
                    if (spare[i + 1]) {
                        spare[i + 1] = false;
                        damaged[i] = false;
                        continue;
                    }
                }
            }
        }
        
        int res = 0;
        for(int i = 1; i <= N; i++){
            if(damaged[i]){
                res++;
            }
        }

        System.out.println(res);
    }
}
