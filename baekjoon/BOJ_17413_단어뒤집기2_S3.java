package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17413_단어뒤집기2_S3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder input = new StringBuilder(br.readLine());
		StringBuilder result = new StringBuilder();
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '<') {

				if (str.length() > 0) {
					for (int j = str.length() - 1; j >= 0; j--) {
						result.append(str.charAt(j));
					}
					str = new StringBuilder();
				}

				int end = i;
				while (input.charAt(end) != '>') {
					result.append(input.charAt(end++));
				}
				result.append('>');
				i = end;
				continue;
			}

			if (input.charAt(i) == ' ') {
				for (int j = str.length() - 1; j >= 0; j--) {
					result.append(str.charAt(j));
				}
				result.append(' ');
				str = new StringBuilder();
				continue;
			}
			str.append(input.charAt(i));
		}

		if (str.length() > 0) {
			for (int j = str.length() - 1; j >= 0; j--) {
				result.append(str.charAt(j));
			}
		}

		System.out.println(result);

	}

}
