package programmers셔틀버스;

import java.util.*;
import java.io.*;

public class programmers셔틀버스 {
	
	static String getTime(int time) {
		
		int hour = 0;
		
		while(time >= 60) {
			hour++;
			time -= 60;
		}
		
		String res = "";
		
		res += Integer.toString(hour / 10);
		res += Integer.toString(hour % 10);
		res += ":";
		res += Integer.toString(time / 10);
		res += Integer.toString(time % 10);
		
		return res;
	}

    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        ArrayList<Integer> mintable = new ArrayList<>();
        		
        for(int i = 0; i < timetable.length; i++) {
        	int min = 0;
        	String[] time = timetable[i].split(":");
        	min += Integer.parseInt(time[0]) * 60;
        	min += Integer.parseInt(time[1]);
        	
        	mintable.add(min);
        }
        
        Collections.sort(mintable);
        int index = 0, time = 540;
        int resultTime = 0;
        
        for(int i = 0; i < n; i++) {
        	
        	int passenger = 0;
        	
        	// 탈수 있는 승객 수 구하기
        	for(int j = index; j < mintable.size(); j++) {
        		if(mintable.get(j) <= time && passenger < m) {
        			index++;
        			passenger++;
        		} else
        			break;
        	}
        	
        	// 마지막 버스이면
        	if(i == n - 1) {
        		// 타야할 승객이 정원을 넘으면
        		if(passenger >= m) {
        			resultTime = mintable.get(index - 1) - 1;
        		}
        		else resultTime = time;
        		
        	} else {
        		time += t;
        	}
        }
        
        answer = getTime(resultTime);
        
        return answer;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] timetable = new String[4];
		
		for(int i = 0; i < timetable.length; i++) {
			timetable[i] = br.readLine();
		}
		
		System.out.println(solution(n, t, m, timetable));
	}
}
