import java.io.*;
import java.util.*;

public class backjoon3425 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		all : while(true) {
			ArrayList<Long> num = new ArrayList<Long>();
			ArrayList<String> op = new ArrayList<String>();
			String operator;
			
			while(!((operator = br.readLine()).equals("END"))) {
	
				if(operator.equals("QUIT")) {
					break all;
				}
				
				if(operator.contains("NUM")) {
					op.add(operator.split(" ")[0]);
					num.add(Long.parseLong(operator.split(" ")[1]));
				} else {
					op.add(operator);
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			
			I : for(int i = 0; i < n; i++) {
				int numIdx = 0;
				
				Stack<Long> stack = new Stack<Long>();
				stack.push(Long.parseLong(br.readLine()));
				for(int j = 0; j < op.size(); j++) {
					Long t1, t2, total;
					int sign;
					
					switch(op.get(j)) {
						case "NUM":
							stack.push(num.get(numIdx++));
							break;
						case "POP":
							if(stack.isEmpty()) {
								System.out.println("ERROR");
								continue I;
							}
							stack.pop();
							break;
						case "INV":
							if(stack.isEmpty()) {
								System.out.println("ERROR");
								continue I;
							}
							t1 = stack.pop() * -1;
							stack.push(t1);
							break;
						case "DUP":
							if(stack.isEmpty()) {
								System.out.println("ERROR");
								continue I;
							}
							stack.push(stack.peek());
							break;
						case "SWP":
							if(stack.size() < 2) {
								System.out.println("ERROR");
								continue I;
							}
							t1 = stack.pop();
							t2 = stack.pop();
							stack.push(t1);
							stack.push(t2);
							break;
						case "ADD":
							if(stack.size() < 2) {
								System.out.println("ERROR");
								continue I;
							}
							t1 = stack.pop();
							t2 = stack.pop();
							total = t1 + t2;
							if(Math.abs(total) > 1000000000) {
								System.out.println("ERROR");
								continue I;
							}
							stack.push(total);
							break;
						case "SUB":
							if(stack.size() < 2) {
								System.out.println("ERROR");
								continue I;
							}
							t1 = stack.pop();
							t2 = stack.pop();
							total = t2 - t1;
							if(Math.abs(total) > 1000000000) {
								System.out.println("ERROR");
								continue I;
							}
							stack.push(total);
							break;
						case "MUL":
							if(stack.size() < 2) {
								System.out.println("ERROR");
								continue I;
							}
							t1 = stack.pop();
							t2 = stack.pop();
							total = t1 * t2;
							if(Math.abs(total) > 1000000000) {
								System.out.println("ERROR");
								continue I;
							}
							stack.push(total);
							break;
						case "DIV":
							if(stack.size() < 2) {
								System.out.println("ERROR");
								continue I;
							}
							t1 = stack.pop();
							t2 = stack.pop();
							
							if(t1 == 0) {
								System.out.println("ERROR");
								continue I;
							}
							
							sign = 0;
							
							if(t1 < 0) {
								t1 *= -1;
								sign++;
							}
							if(t2 < 0) {
								t2 *= -1;
								sign++;
							}
							
							total = t2 / t1;
							
							if(sign == 1) {
								total *= -1;
							}
							
							stack.push(total);
							break;
						case "MOD":
							if(stack.size() < 2) {
								System.out.println("ERROR");
								continue I;
							}
							
							t1 = stack.pop();
							t2 = stack.pop();
							
							if(t1 == 0) {
								System.out.println("ERROR");
								continue I;
							}
							
							sign = 0;
							
							if(t1 < 0) {
								t1 *= -1;
							}
							if(t2 < 0) {
								t2 *= -1;
								sign++;
							}
							
							total = t2 % t1;
							
							if(sign == 1) {
								total *= -1;
							}
							
							stack.push(total);
							break;
					}
				}
				if(stack.size() == 1) {
					bw.write(String.valueOf(stack.pop()));
					bw.newLine();
					bw.flush();
				} else {
					bw.write("ERROR\n");
					bw.flush();
				}
			}
			bw.newLine();
			bw.flush();
			
		}
	}
}