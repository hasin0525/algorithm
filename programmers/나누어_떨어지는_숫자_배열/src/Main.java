import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,5};
		int divisor = 2;
		int[] answer = Arrays.stream(arr).filter(num -> num % divisor == 0).map(num -> num / divisor).sorted().toArray();
		
		System.out.println(answer.length);
	}

}
