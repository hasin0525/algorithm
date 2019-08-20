import java.util.ArrayList;
import java.util.Collections;

class Stage implements Comparable<Stage> {
	int idx, challenge, clear;
	double fail;

	public Stage(int idx, int challenge, int clear) {
		this.idx = idx;
		this.challenge = challenge;
		this.clear = clear;
	}

	public void setFail() {
		if (this.clear == 0) {
			this.fail = 0;
		} else {
			this.fail = (double)this.challenge / (double)this.clear;
		}
	}

	public int compareTo(Stage s) {
		double result = s.fail - this.fail;
		if (result > 0) {
			return 1;
		}
		else if (result == 0) {
			return this.idx - s.idx;
		} else {
			return -1;
		}
	}

}

class Solution {
	public int[] solution(int N, int[] stages) {
		ArrayList<Stage> stageList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			stageList.add(new Stage(i, 0, 0));
		}
        
		for (int i = 0; i < stages.length; i++) {
            int length = stages[i];
            if(stages[i] == N+1){
                length = stages[i]-1;
            }
			for (int j = 0; j < length; j++) {
				stageList.get(j).clear += 1;
			}
			if(stages[i] != N+1) {
				stageList.get(length - 1).challenge += 1;
			}
		}
        
		for (int i = 0; i < N; i++) {
			stageList.get(i).setFail();
		}
		Collections.sort(stageList);

		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = stageList.get(i).idx;

		}
		return answer;
	}
}