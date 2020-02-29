import java.util.ArrayList;
import java.util.List;

class Solution {

	List<String> answer = new ArrayList<>();
	int max;

	public List<String> generateParenthesis(int n) {
		this.max = n;
		backtracking(0, 0, "");
		return answer;
	}

	private void backtracking(int l, int r, String parentheses) {
		if (parentheses.length() == max * 2) {
			answer.add(parentheses);
			return;
		}

		if (l < max) {
			backtracking(l + 1, r, parentheses + "(");
		}
		if (r < l) {
			backtracking(l, r + 1, parentheses + ")");
		}

	}
}