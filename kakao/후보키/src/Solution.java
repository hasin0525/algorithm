import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Solution {
	private int columnLength = 0;
	private ArrayList<int[]> candidatelist = new ArrayList<>();
	
	public boolean isCandidate(int[] attributeList, String[][] r) {
		for (int i = 0; i < r.length - 1; i++) {
			for (int k = i+1; k < r.length; k++) {
				boolean check = true;
				for (int j = 0; j < columnLength; j++) {
					if (attributeList[j] > 0 && r[i][j].compareTo(r[k][j]) != 0) {
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

	public void makeCombination(int index, int[] attributeList, String[][] r) {
		if (index == columnLength) {
			if (isCandidate(attributeList, r)) {
				// 후보키이면 후보키리스트에 넣는다. copy 방식으로...
				int[] newCandidate = new int[columnLength];
				for (int i = 0; i < columnLength; i++) {
					newCandidate[i] = attributeList[i];
				}
				candidatelist.add(newCandidate);
			}
			return;
		}
		for (int i = index; i < columnLength; i++) {
			attributeList[index] = 0;
			makeCombination(i + 1, attributeList, r);
			attributeList[index] = 1;
			makeCombination(i + 1, attributeList, r);
		}
	}
	
	public boolean check(int[] a, int[] b) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == 1 && a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean cacul(ArrayList<int[]> candidatelist) {
		for(int i = 1; i < candidatelist.size();i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(check(candidatelist.get(j), candidatelist.get(i))) {
					candidatelist.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	public int solution(String[][] relation) {
		columnLength = relation[0].length;
		int[] attributeList = new int[columnLength];
		makeCombination(0, attributeList, relation);

		//탐색하면서 중복제거
		while(cacul(candidatelist));
		
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