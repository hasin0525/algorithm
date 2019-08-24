import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
	private int attributeSize;
	private ArrayList<int[]> candidatelist = new ArrayList<>();
	private LinkedList<int[]> result = new LinkedList<>();
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
	
	public boolean minCandidate() {
		// candidatelist를 돌면서 
		for(int i = candidatelist.size() - 1 ; i >= 0 ; i--) {
			for(int j = i-1; j >= 0; j--) {
				isInArray(candidatelist.get(j),candidatelist.get(j-1));
			}
		}
	}

	public void makeCombination(int max, int index, int count, int[] attributeList, String[][] r) {
		if (count == max) {
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
		
		minCandidate();
		
		int answer = candidatelist.size();
		
		for(int[] can : candidatelist) {
			for(int i : can) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		return answer;
	}

}