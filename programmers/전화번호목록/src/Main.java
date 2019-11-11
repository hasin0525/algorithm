import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String[] arr = {"123","12","14","13"};
		Arrays.parallelSort(arr);
		for(String s : arr) {
			System.out.println(s);
		}

	}

}
