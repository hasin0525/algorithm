import java.util.LinkedList;

class Solution {
	private int attributeSize;
	private LinkedList<int[]> candidatelist = new LinkedList<>();

	public boolean isCandidate(int[] attributeList, String[][] r) {
		for (int i = 0; i < r.length - 1; i++) {
			for (int k = i+1; k < r.length; k++) {
				boolean check = true;
				for (int j = 0; j < attributeList.length; j++) {
					if (r[i][attributeList[j]].compareTo(r[k][attributeList[j]]) != 0) {
						check = false;
					}
				}
				if (check) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isInArray(int attribute, int[] attributeList) {
		for(int i : attributeList) {
			if(i == attribute) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isMinCandidate(int[] attributeList) {
		for (int[] candidate : candidatelist) {
			// 전부 똑같은게 있으면 false;
			boolean check = false;
			for (int i = 0; i < candidate.length; i++) {
				check = isInArray(candidate[i], attributeList);
			}
			if (check) {
				return false;
			}
		}
		return true;
	}

	public void makeCombination(int max, int index, int count, int[] attributeList, String[][] r) {
		if (count == max) {
			// 만약 최소 후보키 조건을 만족하지 못한다면 바로 return
			if (!isMinCandidate(attributeList)) {
				return;
			}
			// 여기서 만들어진 attributeList를 가지고 검색을 시작한다.
			if (isCandidate(attributeList, r)) {
				// 후보키이면 후보키리스트에 넣는다. copy 방식으로...
				int[] newCandidate = new int[attributeList.length];
				for (int i = 0; i < newCandidate.length; i++) {
					newCandidate[i] = attributeList[i];
				}
				candidatelist.add(newCandidate);
			}
			return;
		}
		for (int i = index; i < attributeSize; i++) {
			attributeList[count] = i;
			makeCombination(max, i + 1, count + 1, attributeList, r);
		}
	}

	public int solution(String[][] relation) {

		attributeSize = relation[0].length;
		for (int i = 1; i <= attributeSize; i++) {
			// nCi 를 해야한다.
			int[] attributeList = new int[i];
			makeCombination(i, 0, 0, attributeList, relation);
		}

		int answer = candidatelist.size();
		return answer;
	}

}