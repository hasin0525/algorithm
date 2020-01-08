import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
    	boolean isDuplicate = false;
        Set<Integer> countNumber = new HashSet<>();
        for(int num : nums) {
        	if(!countNumber.add(num)) {
        		isDuplicate = true;
        		break;
        	}
        }
        return isDuplicate;
    }
}