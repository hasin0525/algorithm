
public class Main {

	public static void makeCombination(int index, int key) {
		if (index == 4) {
			// 유일성 검증하고 list에 넣는다.
			String s;
			for(int i =3 ; i >= 0; i--) {
				System.out.print((key & (1 << i)) >> i);
			}
			System.out.println();
			return;
		}
		key = key | (1 << index);
		makeCombination(index + 1, key);
		key = key & ~(1 << index);
		makeCombination(index + 1, key);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeCombination(0, 0);
	}

}
