class Solution {
    
    public long GCD(long a, long b) {
   if (b==0) return a;
   return GCD(b,a%b);
}
    
	public long solution(int w, int h) {
		long answer = getAnswer(w, h);

		return (long)w * h - answer;
	}

	private long getAnswer(long w, long h) {
		long answer = 0;
		if (w == h) {
			answer = w;
		} else if (w == 1) {
			answer = h;
		} else if (h == 1) {
			answer = w;
		} else if (w % 2 == 0 && h % 2 == 0) {
			answer = 2 * getAnswer(w / 2, h / 2);
		} else if (w % 2 != 0 && h % 2 != 0) {
            long temp = GCD(w,h);
            if(temp > 1){
                answer = temp * getAnswer(w / temp, h / temp);
            }
            else{
                answer = w + h - 1;    
            }
		} else if (w % 2 == 0) {
			answer = getAnswer(w / 2, h) + w / 2;
		} else if (h % 2 == 0) {
			answer = getAnswer(w, h / 2) + h / 2;
		}
		return answer;
	}
}