import java.util.HashSet;

class Solution2 {
	public int cacul(int a, int b, int c) {
		if (a != b && b != c && c != a) {
			return a * 100 + b * 10 + c;
		} else {
			return 0;
		}
	}

	public int solution(int[][] baseball) {
		HashSet<Integer> set = new HashSet<>();

		for (int[] condition : baseball) {
			int temp = condition[0];
			int[] value = new int[3];
			for (int i = 2; i >= 0; i--) {
				value[i] = temp % 10;
				temp /= 10;
			}
			// strike에 대한 경우의 수 계산
			HashSet<Integer> strike = new HashSet<>();
			switch (condition[1]) {
			case 3:
				return 1;
			case 2:
				for (int i = 1; i <= 9; i++) {
					strike.add(cacul(value[0], value[1], i));
					strike.add(cacul(value[0], i, value[2]));
					strike.add(cacul(i, value[1], value[2]));
				}
				break;
			case 1:
				for (int i = 1; i <= 9; i++) {
					for (int j = 1; j <= 9; j++) {
						strike.add(cacul(value[0], i, j));
						strike.add(cacul(i, j, value[2]));
						strike.add(cacul(i, value[1], j));
					}
				}
				break;
			}
			strike.remove(0);

			// ball에 대한 경우의 수 계산
			HashSet<Integer> ball = new HashSet<>();
			switch (condition[2]) {
			case 3:
				ball.add(cacul(value[2], value[0], value[1]));
				ball.add(cacul(value[1], value[2], value[0]));
				break;
			case 2:
				for (int i = 1; i <= 9; i++) {
					ball.add(cacul(value[1], value[0], i));
					ball.add(cacul(i, value[0], value[1]));
					ball.add(cacul(value[1], i, value[0]));
					ball.add(cacul(i, value[2], value[1]));
					ball.add(cacul(value[2], i, value[1]));
					ball.add(cacul(value[1], value[2], i));
					ball.add(cacul(i, value[2], value[0]));
					ball.add(cacul(value[2], i, value[0]));
					ball.add(cacul(value[2], value[0], i));
				}
				break;
			case 1:
				for (int i = 1; i <= 9; i++) {
					for (int j = 1; j <= 9; j++) {
						ball.add(cacul(i, j, value[0]));
						ball.add(cacul(i, value[0], j));
						ball.add(cacul(i, j, value[1]));
						ball.add(cacul(value[1], i, j));
						ball.add(cacul(i, value[2], j));
						ball.add(cacul(value[2], i, j));
					}
				}
				break;
			}

			ball.remove(0);

			if (condition[1] == 0 && condition[2] == 0) {
				for (int i = 1; i < 10; i++) {
					for (int j = 1; j < 10; j++) {
						for (int k = 1; k < 10; k++) {
							if (i != value[0] && i != value[1] && i != value[2] && j != value[0] && j != value[1]
									&& j != value[2] && k != value[0] && k != value[1] && k != value[2])
								strike.add(cacul(i, j, k));
						}
					}
				}
			}

			// 두개의 set 교집합 후 set에다가 삽입
			if (strike.size() != 0 && ball.size() != 0) {
				strike.retainAll(ball);
			} else if (strike.size() == 0 && ball.size() != 0) {
				strike.addAll(ball);
			}

			if (set.size() == 0) {
				set.addAll(strike);
			} else if (strike.size() != 0) {
				set.retainAll(strike);
			}

		}

		return set.size();
	}
}