class Solution {
	public int[] solution(int brown, int red) {
		int[] answer = new int[2];

		int area = brown + red;
		int max = (brown - 6) / 2 + 2;
		for (int i = 3; i <= max; i++) {
			for (int j = 3; j <= max; j++) {
				if(i*j == area && (2*(i+j) - 4) == brown) {
					answer[0] = j;
					answer[1] = i;
					return answer;
				}
			}
		}
		return new int[]{};
	}
}