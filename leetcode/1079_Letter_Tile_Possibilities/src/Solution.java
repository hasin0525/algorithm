import java.util.HashSet;
import java.util.Set;

class Solution {
	char[] tileArr;

	public int numTilePossibilities(String tiles) {
		tileArr = tiles.toCharArray();
		Set<String> answer = new HashSet<>();
		for (int i = 1; i <= tiles.length(); i++) {
			boolean[] select = new boolean[tiles.length()];
			char[] tile = new char[i];
			makePermutation(0, i, select, answer, tile);
		}
		return answer.size();
	}

	private void makePermutation(int count, int max, boolean[] select, Set<String> answer, char[] tile) {
		if (count == max) {
			answer.add(new String(tile));
			return;
		}
		for (int i = 0; i < tileArr.length; i++) {
			if (!select[i]) {
				select[i] = true;
				tile[count] = tileArr[i];
				makePermutation(count + 1, max, select, answer, tile);
				select[i] = false;
			}
		}
	}
}