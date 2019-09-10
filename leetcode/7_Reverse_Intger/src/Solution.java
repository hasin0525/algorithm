class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(x));
        
        boolean minus = false;
        if(sb.charAt(0) == '-') {
        	minus = true;
        	sb.deleteCharAt(0);
        }
    	sb.reverse();
    	sb.substring(sb.lastIndexOf("0")+1);
    	
    	long reverseNum;
    	if(minus) {
    		reverseNum = Long.parseLong(sb.insert(0, '-').toString());
    	}
    	reverseNum = Long.parseLong(sb.toString());
    	
    	if(Integer.MIN_VALUE > reverseNum || Integer.MAX_VALUE < reverseNum) {
    		return 0;
    	}
    	return (int) reverseNum;
    }
}