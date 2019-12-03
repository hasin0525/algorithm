import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, m;
	static BitSet door;
	static BitSet[] sw;
	static int[] isVisit; // -1 또는 스위치 갯수 k
	static String[] swCombi;

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] input1 = br.readLine().split(" ");
		n = Integer.parseInt(input1[0]);
		m = Integer.parseInt(input1[1]);
		isVisit = new int[2 * n + 1];
		swCombi = new String[2 * n + 1];
		door = new BitSet(n);
		sw = new BitSet[m + 1];

		Arrays.fill(isVisit, -1);
		Arrays.fill(swCombi, "");

		String input = br.readLine();
		for (int i = 0; i < n; i++) {
			if(input.charAt(i) == '1') {
				door.set(i);
			}
		}
		for (int i = 1; i <= m; i++) {
			input = br.readLine();
			sw[i] = new BitSet(n);
			for (int j = 0; j < n; j++) {
				if(input.charAt(j) == '1') {
					sw[i].set(j, true);
				}
			}
		}

		// 1. 스위치의 조합을 만들다.
		boolean[] select = new boolean[m + 1];
		makeCombination(1, select);
		// 2. 기존의 문에 적용시켜 새로운 문을 만든다.
		// 3. 결과값을 저장한다.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2 * n + 1; i++) {
			sb.append(isVisit[i]).append(" ").append(swCombi[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void makeCombination(int index, boolean[] select) {
		if (index == m + 1) {
			int dest = 0;
			BitSet newDoor = (BitSet) door.clone();
			int k = 0;
			StringBuilder sb = new StringBuilder();

			for (int i = 1; i <= m; i++) {
				if (select[i]) {
					k += 1;
					sb.append(i).append(" ");
					newDoor.xor(sw[i]);
				}
			}
			for (int j = 0; j < n; j++) {
				if (newDoor.get(j)) {
					dest += 1;
				} else {
					dest -= 1;
				}
			}
			isVisit[dest + n] = k;
			swCombi[dest + n] = sb.toString();
			return;
		}
		select[index] = true;
		makeCombination(index + 1, select);
		select[index] = false;
		makeCombination(index + 1, select);
	}

}
