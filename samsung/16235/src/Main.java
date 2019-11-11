import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static class Tree implements Comparable<Tree> {
		int r, c, age;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}

	}

	static int n, m, k;
	static Scanner sc = new Scanner(System.in);
	static int[][] map;
	static int[][] a;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static LinkedList<Tree> treelist;
	static LinkedList<Tree> deadTreelist;
	static LinkedList<Tree> newTreeList;

	public static void main(String[] args) {
		treelist = new LinkedList<>();
		deadTreelist = new LinkedList<>();
		newTreeList = new LinkedList<>();
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		a = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < m; i++) {
			treelist.add(new Tree(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = 5;
			}
		}
		for (int i = 0; i < k; i++) {
			start();
		}
		System.out.println(treelist.size());
	}

	private static void start() {
		// 봄
		Collections.sort(treelist);
		Iterator<Tree> it = treelist.iterator();
		while (it.hasNext()) {
			Tree t = it.next();
			if(t.age <= map[t.r][t.c]) {
				map[t.r][t.c] -= t.age;
				t.age+=1;
			} else {
				deadTreelist.add(t);
				it.remove();
			}
		}
		// 여름
		for (Tree t : deadTreelist) {
			map[t.r][t.c] += (t.age / 2);
		}
		deadTreelist.clear();
		// 가을
		newTreeList.clear();
		for (Tree t : treelist) {
			if (t.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int nextR = t.r + dr[i];
					int nextC = t.c + dc[i];
					if (nextR >= 1 && nextR <= n && nextC >= 1 && nextC <= n) {
						newTreeList.add(new Tree(nextR, nextC, 1));
					}
				}
			}
		}
		treelist.addAll(0, newTreeList);
		// 겨울
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] += a[i][j];
			}
		}
	}

}
