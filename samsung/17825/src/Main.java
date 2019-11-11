import java.util.Scanner;

public class Main {
	static class Horse {
		int index, score;
		int[] map;
		boolean end;

		public Horse(int index, int score, int[] map, boolean end) {
			this.index = index;
			this.score = score;
			this.map = map;
			this.end = end;
		}
	}

	static int answer = 0;
	static Horse[] horselist = new Horse[5];
	static int[] originalMap = new int[20];
	static int[] map10 = { 10, 13, 16, 19, 25, 26, 27, 28, 30 };
	static int[] map30 = { 30, 28, 27, 26, 25, 19, 16, 13, 19 };
	static int[] map20 = { 20, 22, 24, 26, 30, 35, 40 };
	static int[] command = new int[10];
	static Scanner sc = new Scanner(System.in);

	public static boolean check(int index, int horseIndex) {
		for (int i = 0; i < 5; i++) {
			if (i != horseIndex && horselist[i].index == index && horselist[i].map.equals(horselist[horseIndex].map)) {
				return true;
			}
		}
		return false;
	}

	public static boolean move(Horse h, int horseIndex) {
		// 특정 위치에 있을때
		// 겹쳐 있을때는
		// 완료일때는
		if (h.map.equals(originalMap)) {
			if (h.index == 5) {
				h.index = 0;
				h.map = map10;
			} else if (h.index == 10) {
				h.index = 0;
				h.map = map20;
			} else if (h.index == 15) {
				h.index = 0;
				h.map = map30;
			} else if (h.index >= 21) {
				h.index = 21;
				h.end = true;
			}
		} else if (h.map.equals(map10)) {
			if (h.index == 4) {
				h.index = 0;
				h.map = map20;
			}
			if (h.index > 8) {
				h.index = (h.index - 8);
				h.map = map20;
			}
		} else if (h.map.equals(map30)) {
			if (h.index == 4) {
				h.index = 0;
				h.map = map20;
			}
			if (h.index > 8) {
				h.index = (h.index - 8);
				h.map = map20;
			}
		} else if (h.map.equals(map20)) {
			if (h.index > 6) {
				h.map = originalMap;
				h.index = 21;
				h.end = true;
			}
		}
		cacul(horseIndex);
		if (!h.end && check(h.index, horseIndex)) {
			return true;
		}
		return false;
	}

	public static void cacul(int horseIndex) {
		Horse h = horselist[horseIndex];
		if (h.map.equals(originalMap)) {
			if (h.index >= 21) {
				h.score += 40;
			} else {
				h.score += h.index * 2;
			}
		} else if (h.map.equals(map10)) {
			h.score += map10[h.index];
		} else if (h.map.equals(map30)) {
			h.score += map30[h.index];
		} else if (h.map.equals(map20)) {
			h.score += map20[h.index];
		}
	}

	public static void backtracking(int commandIndex) {
		if (commandIndex == 10) {
			int temp = 0;
			for (int i = 0; i < 5; i++) {
				temp += horselist[i].score;
			}
			answer = Math.max(answer, temp);
			return;
		}
		// for문으로 5개의 말 ㄱ
		for (int i = 0; i < 5; i++) {
			Horse selectedHorse = horselist[i];
			// 완료일때는 패스
			if (selectedHorse.end) {
				continue;
			}
			int preScore = selectedHorse.score;
			int preIndex = selectedHorse.index;
			int[] preMap = selectedHorse.map;
			selectedHorse.index += command[commandIndex];
			if (move(selectedHorse, i)) {
				selectedHorse.score = preScore;
				selectedHorse.index = preIndex;
				selectedHorse.map = preMap;
			}
			backtracking(commandIndex + 1);
			selectedHorse.score = preScore;
			selectedHorse.index = preIndex;
			selectedHorse.map = preMap;
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			originalMap[i] = i * 2;
		}
		for (int i = 0; i < 10; i++) {
			command[i] = sc.nextInt();
		}
		for (int i = 0; i < 5; i++) {
			horselist[i] = new Horse(0, 0, originalMap, false);
		}
		backtracking(0);
		System.out.println(answer);
	}

}
