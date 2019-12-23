import java.util.LinkedList;
import java.util.Queue;

class Solution {
	class Orange {
		int r, c;
		public Orange(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	int[] dr = {0,0,-1,1};
	int[] dc = {-1,1,0,0};
    public int orangesRotting(int[][] grid) {
    	int answer = 0;
    	int rMax = grid.length;
    	int cMax = grid[0].length;
    	
    	Queue<Orange> q = new LinkedList<>();

    	for (int i = 0; i < rMax; i++) {
			for (int j = 0; j < cMax; j++) {
				if(grid[i][j] == 2) {
					q.add(new Orange(i,j));
				}
			}
		}
    	
    	while(!q.isEmpty()) {
    		int qSize = q.size();
    		for(int i = 0; i < qSize; i++) {
    			Orange cur = q.poll();
    			for(int j = 0; j < 4; j++) {
    				int nextR = cur.r + dr[j];
    				int nextC = cur.c + dc[j];
    				if(nextR >= 0 && nextR < rMax && nextC >= 0 && nextC < cMax && grid[nextR][nextC] == 1) {
    					grid[nextR][nextC] = 2;
    					q.add(new Orange(nextR, nextC));
    				}
    			}
    		}
    		answer++;
    	}
    	
    	for (int i = 0; i < rMax; i++) {
			for (int j = 0; j < cMax; j++) {
				if(grid[i][j] == 1) {
					answer = -1;
					break;
				}
			}
		}
    	
    	return (answer > 0) ? answer -1 : answer;
    }
}