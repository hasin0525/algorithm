import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {

	private boolean[][][] map;
	private int n;

	public int[][] solution(int n, int[][] build_frame) {
		map = new boolean[n+1][n+1][2];
		n = this.n;
		for (int[] command : build_frame) {
			if (command[2] == 0) {
				if (command[3] == 0) {
					deleteGidung(command[0], command[1], command[2]);
				} else {
					insertGidung(command[0], command[1], command[2]);
				}
			} else {
				if (command[3] == 0) {
					deleteBo(command[0], command[1], command[2]);
				} else {
					insertBo(command[0], command[1], command[2]);
				}
			}
		}
		
		LinkedList<int[]> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j][0]) {
					list.add(new int[] {j,i,0});
				} else if (map[i][j][1]) {
					list.add(new int[] {j,i,1});
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int dif = o1[0] - o2[0];
				if (dif == 0) {
					int dif2 = o1[1] - o2[1];
					if (dif2 == 0) {
						return o1[2] - o2[2];
					} else {
						return dif2;
					}
				} else {
					return dif;
				}
			}
			
		});
		
		int[][] result = new int[list.size()][3];
		int max = list.size();
		System.out.println(max);
		for(int i  = 0 ; i < max; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	private void insertBo(int x, int y, int isExist) {
		// 이미 보가 있으면
		if (map[y][x][isExist]) {
			return;
		}
		if (x == 0) {
			// 아래가 기둥이 없으면
			if (!map[y - 1][x][0]) {
				return;
			}
		} else if (x == n - 2) {
			// 아래가 기둥이 없으면
			if (!map[y - 1][x + 1][0]) {
				return;
			}
		} else {
			// 아래가 기둥인데 보가 끝부분이 아니면 x
			if (map[y - 1][x][0] && map[y][x - 1][isExist]) {
				return;
			}
			// 양쪽 끝에 보가 없으면
			if (!(map[y][x - 1][isExist] && map[y][x + 1][isExist])) {
				return;
			}
		}
		map[y][x][isExist] = true;
	}

	private void deleteBo(int x, int y, int isExist) {
		if (x == 0) {
			// 자신의 옆에 보가 있으면 안된다.
			if (map[y][x + 1][isExist]) {
				return;
			}
			// 아래에 기둥이 바닥에 붙어 있으면 안된다.
			if (y - 1 == 0 && map[y - 1][x][0]) {
				return;
			}
		} else {
			// 자신의 옆에 보가 있으면 안된다.
			if (map[y][x - 1][isExist] && map[y][x + 1][isExist]) {
				return;
			}
			// 아래에 기둥이 바닥에 붙어 있으면 안된다.
			if (y - 1 == 0 && map[y - 1][x][0]) {
				return;
			}
		}
		map[y][x][isExist] = false;
	}

	private void insertGidung(int x, int y, int isExist) {
		// 자기 자신의 위치에 기둥이 없어야 한다.
		if (map[y][x][isExist]) {
			return;
		}
		if (y == 0) {
			// 기둥의 위쪽 왼쪽에 보가 있으며 안된다.
			if (x - 1 >= 0 && map[y + 1][x - 1][1]) {
				return;
			}
		} else {
			// 한쪽이 바닥 끝이 아니면 그 아래가 기둥이어야 한다.
			if (!map[y - 1][x][0]) {
				return;
			}
		}
		map[y][x][isExist] = true;
	}

	private void deleteGidung(int x, int y, int isExist) {
		if (y == 0) {
			// 보의 끝부분이면 빠지면 안된다.
			if (!map[y + 1][x - 1][1] && map[y + 1][x][1]) {
				return;
			}
			// 위에 기둥이 있으면 빠지면 안된다.
			if (map[y + 1][x][isExist]) {
				return;
			}
		} else {
			// 위나 아래에 기둥이 있으면 빠지면 안된다.
			if (map[y - 1][x][isExist] || map[y + 1][x][isExist]) {
				return;
			}
			// 아래나 위가 보의 끝부분이면 빠지면 안된다.
			if ((!map[y - 1][x - 1][isExist] && map[y - 1][x][isExist])
					|| (!map[y + 1][x - 1][isExist] && map[y + 1][x][isExist])) {
				return;
			}
		}
		map[y][x][isExist] = false;
	}
}