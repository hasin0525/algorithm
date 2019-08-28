import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Info{
		int x, y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static Scanner sc = new Scanner(System.in);
	static int r = 10, c=9, kr, kc;
	static boolean[][] visited;
	static int[][] dx = {{-1,-1,-1},{-1,-1,-1},{1,1,1},{1,1,1},{0,-1,-1},{0,1,1},{0,-1,-1}, {0,1,1}};
	static int[][] dy = {{0,-1,-1},{0,1,1},{0,-1,-1},{0,1,1},{-1,-1,-1},{-1,-1,-1},{1,1,1},{1,1,1}};
	static Queue<Info> q;
	
	public static int bfs() {
		int count = 0;
		while(!q.isEmpty()) {
			int qsize = q.size();
			for(int i = 0 ; i < qsize; i++) {
				Info cur = q.poll();
				if(cur.x == kr && cur.y == kc) {
					return count;
				}
				for(int j = 0; j < 8; j++) {
					int nextX = cur.x;
					int nextY = cur.y;
					boolean check = true;
					for(int k = 0; k < 3; k++) {
						nextX += dx[j][k];
						nextY += dy[j][k];
						if(nextX < 0 || nextX >= r || nextY < 0 || nextY >= c || (k!=2 && nextX == kr && nextY == kc)) {
							check = false;
							break;
						}
					}
					if(check) {
						visited[nextX][nextY] = true;
						q.add(new Info(nextX, nextY));
					}
					
				}
			}
			count++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		visited = new boolean[r][c];
		q = new LinkedList<>();
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		kr = sc.nextInt();
		kc = sc.nextInt();
		visited[r1][c1] = true;
		q.add(new Info(r1,c1));
		System.out.println(bfs());
	}

}
