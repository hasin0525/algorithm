import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int A, B, N, b1, b2, answer;

	public static void main(String[] args) {
		A = sc.nextInt();
		B = sc.nextInt();
		N = sc.nextInt();

		List<Integer> priceList = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			priceList.add(sc.nextInt());
		}

		for (int i = 0; i < N; i++) {
			b1 = 0;
			b2 = 0;
			priceList.add(i, 0);
			for (int j = 1; j <= N; j++) {
				if (j % 2 != 0) {
					b1 += priceList.get(j - 1);
				} else {
					b2 += priceList.get(j - 1);
				}
			}

			isAnswer(priceList, i);

			priceList.remove(i);
		}
		System.out.println(answer);
	}

	private static void isAnswer(List<Integer> priceList, int index) {
		if (index == 0 || index == priceList.size() - 1) {
			answer += 1;
			return;
		}
		if (index >= 1 && index < priceList.size() - 1) {
			for (int price = priceList.get(index + 1); price <= priceList.get(index - 1); price++) {
				if (index % 2 != 0) {
					if (Math.abs(b1 + price - b2) >= A && Math.abs(b1 + price - b2) <= B) {
						answer += 1;
						break;
					}
				} else {
					if (Math.abs(b1 - b2 - price) >= A && Math.abs(b1 - b2 - price) <= B) {
						answer += 1;
						break;
					}
				}
			}
		}
	}

}
