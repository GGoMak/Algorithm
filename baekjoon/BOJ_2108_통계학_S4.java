import java.io.*;
import java.util.*;

public class BOJ_2108_통계학_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList();
		
		int[] arr = new int[N];
		int[] fre = new int[8001];
		
		double sum = 0;
		int maxFre = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			fre[arr[i] + 4000]++;
			
			if(maxFre < fre[arr[i] + 4000]) {
				maxFre = fre[arr[i] + 4000];
				list.clear();
				list.add(arr[i]);
			}
			else if(maxFre == fre[arr[i] + 4000]) {
				list.add(arr[i]);
			}
		}
		
		System.out.printf("%.0f\n", sum / N);
		
		Arrays.sort(arr);
		System.out.println(arr[N / 2]);
		
		Collections.sort(list);
		if(list.size() == 1) {
			System.out.println(list.get(0));
		} else {
			System.out.println(list.get(1));
		}
		
		System.out.println(arr[N - 1] - arr[0]);
		
		
	}
}
