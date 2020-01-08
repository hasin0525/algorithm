import java.util.ArrayList;
import java.util.List;

class Solution {
	private List<List<Integer>> answer = new ArrayList<>();
	private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
    	answer.add(new ArrayList<Integer>());
    	boolean[] selected = new boolean[this.nums.length];
    	
        for (int size = 1; size <= nums.length; size++) {
			combi(0, 0,size, selected);
		}
        
    	return answer;
    }
	private void combi(int index, int count, int size, boolean[] selected) {
		if(count == size) {
			List<Integer> subset = new ArrayList<>();
			for (int i = 0; i < selected.length; i++) {
				if(selected[i]) {
					subset.add(this.nums[i]);
				}
			}
			answer.add(subset);
			return;
		}
		if(index == selected.length) {
			return;
		}
		selected[index] = true;
		combi(index+1,count+1,size,selected);
		selected[index] = false;
		combi(index+1,count,size,selected);
	}
}