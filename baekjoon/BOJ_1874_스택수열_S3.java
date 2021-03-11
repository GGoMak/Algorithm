package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택수열_S3 {

    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        
        int num = 1; // 스택에 1 ~ N 까지 수를 넣기위한 변수
        int idx = 0; // arr배열의 인덱스
        
        while(idx < N) {
        	
        	// 빼야할 숫자까지 넣기
        	while(num <= N && arr[idx] != num) {
        		sb.append("+\n");
        		s.push(num++);
        	}
        	if(num <= N) {
	        	sb.append("+\n");
	        	s.push(num++);
        	}
        	
        	// 스택에서 빼야할 숫자랑 인덱스의 숫자랑 다르면 불가능한 수열
        	if(arr[idx] != s.peek()) {
        		sb = new StringBuilder("NO");
        		break;
        	}
        	
        	// 스택에서 뺄수 있는 숫자 다 빼기
        	while(!s.isEmpty() && s.peek() == arr[idx]) {
        		sb.append("-\n");
        		s.pop();
        		idx++;
        	}
        }
        
        
        System.out.println(sb);
    }
}
