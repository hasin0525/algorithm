import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    	Arrays.sort(queens, new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				int d1 = Math.abs(king[0] - o1[0]) + Math.abs(king[1] - o1[1]);
				int d2 = Math.abs(king[0] - o2[0]) + Math.abs(king[1] - o2[1]);
				return d1 - d2;
			}
    	});
    	List<List<Integer>> answer = new LinkedList<>();
        for(int[] q : queens) {
        	int r = q[0];
        	int c = q[1];
        	
        	if(king[0] == r || king[1] == c) {
        		LinkedList<Integer> list = new LinkedList<>();
        		list.add(r);
        		list.add(c);
        		answer.add(list);
        	}
        	
        	if(Math.abs(r - king[0]) == Math.abs(c - king[1])) {
        		LinkedList<Integer> list = new LinkedList<>();
        		list.add(r);
        		list.add(c);
        		answer.add(list);
        	}
        }
        return answer;
    }
}