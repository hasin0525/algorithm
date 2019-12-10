import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> partitionLengths = new LinkedList<>();
    	int[] lastIndexForChar = new int[26];
        for(int i = 0; i < S.length(); i++) {
        	lastIndexForChar[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        while(start < S.length()) {
        	int max = lastIndexForChar[S.charAt(start) - 'a'];
            int count = 1;
            for(int i = start; i < max; i++) {
            	int lastIndex = lastIndexForChar[S.charAt(i) - 'a'];
            	max = Math.max(max, lastIndex);
                count++;
        	}
        	start = max + 1;
        	partitionLengths.add(count);
            
        }
        
        return partitionLengths;
    }
}