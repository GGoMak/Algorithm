import java.util.*;
public class baekjoon3055 {
	
	static int hedX, hedY;
	static int bTunnelX, bTunnelY;
	static int R, C;
	
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		
		char[][] map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			char[] t = sc.next().toCharArray();
			for(int j = 0; j < C; j++) {
				map[i][j] = t[j];
				if(t[j] == 'S') {
					hedX = i;
					hedY = j;
					map[i][j] = '.';
				} else if(t[j] == 'D') {
					bTunnelX = i;
					bTunnelY = j;
				}
			}
		}
		
		boolean[][] visit = new boolean[R][C];
		visit[hedX][hedY] = true;
		int result = bfs(hedX, hedY, map);
		
		if(result == 987654321) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(result);
		}
	}
	
	static int bfs(int x, int y, char[][] map) {
		
		boolean[][] visit = new boolean[R][C];
		int preCnt = -1;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y, 0));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int nx = q.peek().x;
			int ny = q.peek().y;
			int cnt = q.peek().cnt;
			q.poll();
			
			if(preCnt < cnt) {
				waterfall(map);
				preCnt = cnt;
			}
			
			if(map[nx][ny] == 'D') {
				return cnt;
			}
			
			for(int i = 0; i < 4; i++) {
				int nnx = nx + deltas[i][0];
				int nny = ny + deltas[i][1];
				
				if(nnx < 0 || nny < 0 || nnx >= R || nny >= C) {
					continue;
				}
				
				if((map[nnx][nny] == '.' || map[nnx][nny] == 'D') && !visit[nnx][nny]) {
					q.add(new Node(nnx, nny, cnt + 1));
					visit[nnx][nny] = true;
				}
			}
		}
		
		return 987654321;
		
	}
	
	static void waterfall(char[][] map) {
		
		char[][] tMap = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				tMap[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == '*') {
					for(int k = 0; k < 4; k++) {
						int nx = i + deltas[k][0];
						int ny = j + deltas[k][1];
						
						if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
							continue;
						}
						
						if(map[nx][ny] == '.') {
							tMap[nx][ny] = '1';
						}
					}
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(tMap[i][j] == '1') {
					map[i][j] = '*';
				}
			}
		}
	}
}

class Node {
	int x, y, cnt;
	Node(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
