
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int a = 0; a < 10; a++) {
			Solution s = new Solution();
			long start = System.currentTimeMillis();
			
			for (long i = 0; i < 50000000L; i++) {
				s.isAnagram("asdfasdfasdfasdfaergearsadfasdfasdfaregeriaoghjbrotihnbiugoibareoghareiuhgufadlihlgaehatrhrsthrsthrsthsge", "asdfasdfasdfasdfaergearsadfasdfasdfaregeriaoghjbrotihnbiugoibareoghareiuhgufadlihlgaehatrhrsthrsthrsthsge");
			}
			long end = System.currentTimeMillis();
			System.out.println( "실행 시간1 : " + ( end - start ) / 1000);
			
			start = System.currentTimeMillis();
			
			for (long i = 0; i < 50000000L; i++) {
				s.isAnagram2("asdfasdfasdfasdfaergearsadfasdfasdfaregeriaoghjbrotihnbiugoibareoghareiuhgufadlihlgaehatrhrsthrsthrsthsge", "asdfasdfasdfasdfaergearsadfasdfasdfaregeriaoghjbrotihnbiugoibareoghareiuhgufadlihlgaehatrhrsthrsthrsthsge");
			}
			end = System.currentTimeMillis();
			System.out.println( "실행 시간2 : " + ( end - start) / 1000);
		}
		
	}

}
