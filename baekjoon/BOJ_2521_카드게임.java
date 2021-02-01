package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2521_카드게임 {
	
	static int[] numCnt = new int[10];
	static int[] colorCnt = new int[4];
	static int[] num = new int[5];
	static char[] color = new char[5];
	
	public static int one() {
		
		for(int i = 0; i < 4; i++) {
			if(colorCnt[i] == 5) {
				int check = 0;
				for(int j = 0; j < 4; j++) {
					if(num[j] == num[j + 1] - 1) {
						check++;
						if(check == 4) {
							return num[j + 1] + 900;
						}
					}
					else {
						check = 0;
					}
				}
			}
		}
		
		return 0;
	}
	
	public static int two() {
		for(int i = 1; i < 10; i++) {
			if(numCnt[i] == 4) {
				return i + 800;
			}
		}
		
		return 0;
	}
	
	public static int three() {
		
		int[] checkNum = new int[10];
		
		for(int i = 0; i < 5; i++) {
			checkNum[num[i]]++;
		}
		
		int thr = 0, two = 0;
		
		for(int i = 1; i < 10; i++) {
			if(checkNum[i] == 3) {
				thr = i;
			}
			if(checkNum[i] == 2) {
				two = i;
			}
		}
		
		if(thr != 0 && two != 0) {
			return (thr * 10) + two + 700; 
		}
		
		return 0;
	}
	
	static int four() {
		
		for(int i = 0; i < 4; i++) {
			if(colorCnt[i] == 5) {
				int max = 0;
				
				for(int j = 0; j < 5; j++) {
					if(max < num[j]) {
						max = num[j];
					}
				}
				
				return max + 600;
			}
		}
		
		return 0;
	}
	
	static int five() {
		
		int check = 0;
		for(int j = 0; j < 4; j++) {
			if(num[j] == num[j + 1] - 1) {
				check++;
				if(check == 4) {
					return num[j + 1] + 500;
				}
			}
			 else {
				check = 0;
			}
		}
		
		return 0;
	}
	
	static int six() {
		
		for(int i = 1; i < 10; i++) {
			if(numCnt[i] == 3) {
				return 400 + i;
			}
		}
		
		return 0;
	}
	
	static int seven() {
		int first = 0, second = 0;
		int check = 0;
		for(int i = 1; i < 10; i++) {
			if(numCnt[i] == 2 && check == 0) {
				first = i;
				check++;
			}
			else if(numCnt[i] == 2 && check == 1){
				second = i;
			}
		}
			
		if(first == 0 || second == 0) {
			return 0;
		}
		return second * 10 + first + 300;
	}
	
	static int eight() {
		for(int i = 1; i < 10; i++) {
			if(numCnt[i] == 2) {
				return i + 200;
			}
		}
		
		return 0;
	}
	
	static int nine() {
		
		return num[4] + 100;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			color[i] = st.nextToken().charAt(0);
			if(color[i] == 'R') {
				colorCnt[0]++;
			} else if(color[i] == 'B') {
				colorCnt[1]++;
			} else if(color[i] == 'Y') {
				colorCnt[2]++;
			} else {
				colorCnt[3]++;
			}
			num[i] = Integer.parseInt(st.nextToken());
			numCnt[num[i]]++;
		}
		
		Arrays.sort(num);
		
		int jumsu = 0;
		int t;
		
		if((t = one()) != 0) {
			jumsu += t;
		} else if((t = two()) != 0) {
			jumsu += t;
		} else if((t = three()) != 0) {
			jumsu += t;
		} else if((t = four()) != 0) {
			jumsu += t;
		} else if((t = five()) != 0) {
			jumsu += t;
		} else if((t = six()) != 0) {
			jumsu += t;
		} else if((t = seven()) != 0) {
			jumsu += t;
		} else if((t = eight()) != 0) {
			jumsu += t;
		} else {
			jumsu += nine();
		}
		
		System.out.println(jumsu);
	}
}
