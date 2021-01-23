import java.util.*;

public class programmers뉴스클러스터링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		System.out.println(solution(str1, str2));
	}
	
	public static int solution(String str1, String str2) {
		int answer = 0;
		int str1Size = str1.length();
		int str2Size = str2.length();
		
		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		
		for(int i = 0; i < str1.length() - 1; i++) {
			char[] t = str1.substring(i, i + 2).toUpperCase().toCharArray();
			if(('A' <= t[0] && t[0] <= 'Z') && ('A' <= t[1] && t[1] <= 'Z')){
				arr1.add(String.valueOf(t));
			}
		}
		for(int i = 0; i < str2.length() - 1; i++) {
			char[] t = str2.substring(i, i + 2).toUpperCase().toCharArray();
			if(('A' <= t[0] && t[0] <= 'Z') && ('A' <= t[1] && t[1] <= 'Z')){
				arr2.add(String.valueOf(t));
			}
		}
		
		if(arr1.size() == 0 && arr2.size() == 0) {
			return 65536;
		}
		
		int intersectionSize = 0, unionSize = 0;
		
		HashMap<String, Integer> m1 = new HashMap<String, Integer>();
		HashMap<String, Integer> m2 = new HashMap<String, Integer>();
		
		for(int i = 0; i < arr1.size(); i++) {
			if(!m1.containsKey(arr1.get(i))) {
				m1.put(arr1.get(i), 1);
				continue;
			}
			m1.put(arr1.get(i), m1.get(arr1.get(i)) + 1);
		}
		
		for(int i = 0; i < arr2.size(); i++) {
			if(!m2.containsKey(arr2.get(i))) {
				m2.put(arr2.get(i), 1);
				continue;
			}
			m2.put(arr2.get(i), m2.get(arr2.get(i)) + 1);
		}
		
		for(String key : m1.keySet()) {
			if(m2.containsKey(key)) {
				intersectionSize += Math.min(m1.get(key), m2.get(key));
			}
		}
		
		for(String key : m1.keySet()) {
			if(m2.containsKey(key)) {
				unionSize += Math.max(m1.get(key), m2.get(key));
				m1.put(key, 0);
				m2.put(key, 0);
			} else {
				unionSize += m1.get(key);
				m1.put(key, 0);
			}
		}
		
		for(String key : m2.keySet()) {
			unionSize += m2.get(key);
		}
		
		
		double jaccard = (double)intersectionSize / unionSize;
		answer = (int)(65536 * jaccard);
		
		return answer;
	}
	
}
