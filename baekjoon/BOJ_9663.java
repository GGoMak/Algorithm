package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9663 {

   static int N, result = 0;
   static boolean[][] map;
   
   public static boolean check(int x, int y, int cnt) {

      // column 검사
      for(int i = 0; i < cnt; i++) {
         if(map[i][y]) return false;
      }
      
      // 왼쪽 위 대각선 검사
      int j = y - 1;
      for(int i = cnt - 1; i >= 0; i--) {
         if(j < 0) {
            break;
         }
         if(map[i][j]) return false;
         j--;
      }
         
      // 오른쪽 위 대각선 검사
      j = y + 1;
      for(int i = cnt - 1; i >= 0; i--) {
         if(j >= N) {
            break;
         }
         if(map[i][j]) return false;
         j++;
      }
      
      return true;
   }
   
   public static void dfs(int start, int cnt) {
      
      if(cnt == N) {
         result++;
         return;
      }
      
      for(int i = 0; i < N; i++) {
         if(check(start, i, cnt)) {
            map[start][i] = true;
            dfs(start + 1, cnt + 1);
            map[start][i] = false;
         }
      }
   }
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
      N = Integer.parseInt(br.readLine());
      map = new boolean[N][N];
      dfs(0, 0);
      
      System.out.println(result);
   }

}