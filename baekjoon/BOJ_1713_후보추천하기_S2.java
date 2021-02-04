import java.util.*;

public class BOJ_1713_후보추천하기_S2 {
	
	static int N, total;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		total = sc.nextInt();
		
		ArrayList<Node> m = new ArrayList<Node>(N);
		
		for(int i = 0; i < total; i++) {
			int n = sc.nextInt();
			
			if(!isContain(m, n)) {
				if(m.size() >= N) {
					deleteStudent(m, n);
				}
				m.add(new Node(n, 1));
			} else {
				for(int j = 0; j < m.size(); j++) {
					if(n == m.get(j).id) {
						Node t = m.get(j);
						t.cnt++;
						m.set(j, t);
					}
				}
			}
		}
		
		Collections.sort(m);
		
		for(int i = 0; i < m.size(); i++) {
			System.out.printf("%d ", m.get(i).id);
		}
		
	}
	
	static boolean isContain(ArrayList<Node> m, int n) {
		for(int i = 0; i < m.size(); i++) {
			if(m.get(i).id == n) {
				return true;
			}
		}
		
		return false;
	}
	
	static void deleteStudent(ArrayList<Node> m, int n) {
		
		int min = 987654321;
		int index = 0;
		
		for(int i = 0; i < m.size(); i++) {
			if(min > m.get(i).cnt) {
				min = m.get(i).cnt;
				index = i;
			}
		}
		
		m.remove(index);
	}
}

class Node implements Comparable<Node> {
	int id;
	int cnt;
	Node(int id, int cnt){
		this.id = id;
		this.cnt = cnt;
	}
	
	@Override
	public int compareTo(Node a) {
		if(this.id < a.id) {
			return -1;
		} else if(this.id > a.id) {
			return 1;
		} return 0;
	}
}
