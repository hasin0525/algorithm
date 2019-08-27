import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static class Shark {
		int r, c, s, d, z;
		boolean move;

		public Shark(int r, int c, int s, int d, int z, boolean move) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.move = move;
		}

	}

	static Scanner sc = new Scanner(System.in);
	static int[][] map;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };
	static int[] newd = {0,2,1,4,3};
	static int r, c, m, result;
	static HashMap<Integer, Shark> sharkList;

	public static void moving() {
		// 상어들을 이동시킨다.
		Set<Integer> ss = sharkList.keySet();
		Iterator<Integer> it = ss.iterator();
		while(it.hasNext()) {
			int s = it.next();
			Shark cur = sharkList.get(s);
			if (cur.z == map[cur.r][cur.c]) {
				map[cur.r][cur.c] = 0;
			}
			int nextR = cur.r;
			int nextC = cur.c;
			for(int i = 0; i < cur.s; i++) {
				nextR += dx[cur.d];
				nextC += dy[cur.d];
				if(nextR < 1 || nextR > r || nextC < 1 || nextC > c) {
					nextR -= dx[cur.d];
					nextC -= dy[cur.d];
					cur.d = newd[cur.d];
					nextR += dx[cur.d];
					nextC += dy[cur.d];
				}
			}
			cur.move = true;
			cur.r = nextR;
			cur.c = nextC;
			int value = cur.z; 
			if(map[cur.r][cur.c] == 0) {
				map[cur.r][cur.c] = value;
			} else {
				if(sharkList.get(map[cur.r][cur.c]).move) {
					if(cur.z > map[cur.r][cur.c]) {
						sharkList.remove(map[nextR][nextC]);
						map[nextR][nextC]  = value;
					}else {
						sharkList.remove(value);
					}
				} else {
					map[cur.r][cur.c] = value;
				}
			}
		}
		//다 끝난 후 이동은 전부 false로 바꾼다.
		for (Entry<Integer, Shark> s : sharkList.entrySet()) {
			s.getValue().move = false;
		}
	}

	public static void eating(int row, int col) {
		// 낚시왕이 상어를 잡는다.
		sharkList.remove(map[row][col]);
		result += map[row][col];
		map[row][col] = 0;
	}

	public static void main(String[] args) {
		// 맵을 1부터 시작했다.
		r = sc.nextInt();
		c = sc.nextInt();
		m = sc.nextInt();
		map = new int[r + 1][c + 1];
		sharkList = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			sharkList.put(z, new Shark(r, c, s, d, z, false));
			map[r][c] = z;
		}
		// 낚시왕이 오른쪽으로 한칸 이동한다.
		for (int i = 1; i <= c; i++) {
			for (int j = 1; j <= r; j++) {
				if (map[j][i] > 0) {
					eating(j, i);
					break;
				}
			}
			moving();
		}
		System.out.println(result);
	}

}
