package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1431_시리얼번호_S3 {

    static int N;
    static String[] str;

    public static int getNum(String a){

        int sum = 0;

        for(int i = 0; i < a.length(); i++){
            if('0' <= a.charAt(i) && a.charAt(i) <= '9'){
                sum += a.charAt(i) - '0';
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        str = new String[N];

        for(int i = 0; i < N; i++){
            str[i] = br.readLine();
        }

        Arrays.sort(str, (o1, o2) -> {
            if(o1.length() != o2.length()){
                return Integer.compare(o1.length(), o2.length());
            } else {
                int num1 = getNum(o1);
                int num2 = getNum(o2);

                if(num1 != num2){
                    return Integer.compare(num1, num2);
                }

                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            sb.append(str[i] + "\n");
        }

        System.out.println(sb);
    }
}
