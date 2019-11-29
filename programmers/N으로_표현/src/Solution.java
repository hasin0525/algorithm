class Solution {
	int answer = -1;

	public int solution(int N, int number) {
		dfs(N, 0, 0, number, "");
		return answer;
	}

	public void dfs(int n, int count, int prev, int number, String s) {
		if (count > 8)
			return;
		if (prev == number) {
			if (count < answer || answer == -1) {
				
				System.out.print(s);
				System.out.print(" " + count);
				System.out.println();
				answer = count;
			}
			return;
		}
		int nn = 0;
		for (int i = 0; i < 8; i++) {
			nn = nn * 10 + n;
			dfs(n, count + 1 + i, prev + nn, number, s + "+");
			dfs(n, count + 1 + i, prev - nn, number, s + "-");
			dfs(n, count + 1 + i, prev * nn, number, s + "*");
			dfs(n, count + 1 + i, prev / nn, number, s + "/");
		}
	}
}