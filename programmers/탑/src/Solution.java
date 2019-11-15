class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for(int i = 0; i < heights.length; i++) {
        	int h = heights[i];
        	for(int j = 0; j < i; j++) {
        		if(heights[j] > h) {
        			answer[i] = j+1;
        		}
        	}
        }
        
        return answer;
    }
}