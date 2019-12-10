import java.util.List;

class Solution {

	public int dfs(int index, boolean[] isVisited, List<List<Integer>> rooms) {
		int c = 0;
		List<Integer> keys = rooms.get(index);
		for (int key : keys) {
			if (!isVisited[key]) {
				isVisited[key] = true;
				c += 1;
				c += dfs(key, isVisited, rooms);
			}
		}
		return c;
	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] isVisited = new boolean[rooms.size()];
		isVisited[0] = true;
		int count = dfs(0, isVisited, rooms) + 1;
		if (count == rooms.size()) {
			return true;
		} else {
			return false;
		}
	}
}