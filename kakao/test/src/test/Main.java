package test;

public class Main {
	static int[] arr = { 1, 2, 3, 4, 5 };
	// 몇개를 선택할 것인가.
	static int R = 4;

	//	위치를 선택하는 법
	public static void makeCombination2(int index, int count, int[] c) {
		if(count == arr.length) {
			for(int i : c) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		c[count]=1;
		makeCombination2(index+1, count+1, c);
		c[count]=0;
		makeCombination2(index+1, count+1, c);
	}
	
	public static void overlapCombination(int index, int count, int[] c) {
		if(count == R) {
			for(int i : c) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		if(index >= arr.length) {
			return;
		}
		c[count] = arr[index];
		overlapCombination(index, count+1, c);
		overlapCombination(index+1, count, c);
	}
	
	public static void makeCombination(int index, int count, int[] c) {
		if(count == R) {
			for(int i : c) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		if(index >= arr.length) {
			return;
		}
		c[count] = arr[index];
		makeCombination(index+1, count+1, c);
		makeCombination(index+1, count, c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 조합을 담을 배열
		int[] c = new int[arr.length];
		overlapCombination(0, 0, c);
	}

}
