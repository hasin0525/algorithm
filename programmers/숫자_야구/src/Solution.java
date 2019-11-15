import java.util.HashSet;

class Solution {

	public int cacul(int a, int b, int c) {
		if (a != b && b != c && c != a) {
			return a * 100 + b * 10 + c;
		} else {
			return 0;
		}
	}

	public int solution(int[][] baseball) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					int temp = cacul(i,j,k); 
					if(temp == 0) {
						continue;
					}
					int[] num = new int[3];
					for (int l = 2; l >= 0; l--) {
						num[l] = temp % 10;
						temp /= 10;
					}
					
					boolean isOk = true;
					for (int[] condition : baseball) {
						temp = condition[0];
						int[] input = new int[3];
						for (int l = 2; l >= 0; l--) {
							input[l] = temp % 10;
							temp /= 10;
						}
						
						int s = 0;
						int b = 0;
						for(int m = 0; m < 3; m++) {
							for(int n = 0; n < 3; n++) {
								if(num[m] == input[n] && m == n) {
									s+=1;
								}else if(num[m] == input[n] && m != n) {
									b+=1;
								}
							}
						}
						
						if(!(s == condition[1] && b == condition[2])) {
							isOk = false;
						}
					}
					if(isOk) {
						set.add(cacul(i,j,k));
					}
				}
			}
		}
		return set.size();
	}
}