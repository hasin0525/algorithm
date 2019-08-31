import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int solution(int cacheSize, String[] cities) {
	  Queue<String> q = new LinkedList<>();
      int answer = 0;
      for(String ss : cities) {
    	  String s = ss.toLowerCase(); 
    	  if (cacheSize == 0) {
    		  answer += 5;
    	  }
    	  else {
        	  if(q.contains(s)) {
        		  q.remove(s);
        		  q.add(s);
        		  answer += 1;
        	  } else {
        		  if(q.size() == cacheSize) {
        			  q.poll();
        		  }
        		  q.add(s);
        		  answer += 5;
        	  }
    	  }
      }
      return answer;
  }
}