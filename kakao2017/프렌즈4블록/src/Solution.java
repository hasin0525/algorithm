class Solution {
	char[][] map;
	boolean[][] delete;

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		map = new char[m][n];
		delete = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			String input = board[i];
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		while (true) {
			int newAnswer = 0;
			// 루프문으로 탐색하자.
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j] != '0' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j]
							&& map[i][j] == map[i + 1][j + 1]) {
						delete[i][j] = true;
						delete[i][j + 1] = true;
						delete[i + 1][j] = true;
						delete[i + 1][j + 1] = true;
					}
				}
			}
			// delete가 true인 곳을 전부 지우자.
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (delete[i][j]) {
						delete[i][j] = false;
						newAnswer++;
						map[i][j] = '0';
					}
				}
			}
			if(newAnswer == 0) {
				break;
			} else{
				answer += newAnswer;
			}
			// 밑으로 내리자
			while (true) {
				int newCount = 0;
				for (int j = 0; j < n; j++) {
					for (int i = m - 2; i >= 0; i--) {
						if (map[i][j] != '0' && map[i + 1][j] == '0') {
							map[i + 1][j] = map[i][j];
							map[i][j] = '0';
							newCount++;
						}
					}
				}
				if (newCount == 0) {
					break;
				}
			}
		}

		return answer;
	}
}