
class Solution {
    public int countPrimes(int n) {
    	boolean[] isNotPrime = new boolean[n];
    	
    	for(int i = 2; i < Math.sqrt(n); i++) {
    		if(isNotPrime[i]) continue;
        	for(int j = 2; i*j <n ; j++) {
        		isNotPrime[i*j] = true;
        	}
        }
    	int count = 0;
    	for(int i = 2; i < n; i++) {
    		if(!isNotPrime[i]) {
    			count++;
    		}
    	}
    	return count;
    }
}