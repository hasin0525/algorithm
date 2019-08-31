import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
	public int solution(String dartResult) {
		int answer = 0;
		String[] parse = new String[3];
		Pattern p = Pattern.compile("(([0-9]|[0-9]{2}?)[STD][*#]?)");
		Matcher m = p.matcher(dartResult);
		int index = 0;
		while (m.find()) {
			parse[index] = m.group(1);
			index++;
		}
		
		String[][] resultPared = new String[3][3];
		for(int i = 0; i < 3; i++) {
			p = Pattern.compile("([0-9]?[10]?)([S|T|D])([*|#]?)");
			m = p.matcher(parse[i]);
			while (m.find()) {
				resultPared[i][0] = m.group(1);
				resultPared[i][1] = m.group(2);
				if(m.group(3) != null) {
					resultPared[i][2] = m.group(3);
				}
			}
		}

		int[] a = new int[3];
		
		for(int i = 0; i < 3; i++) {
			cacul(a,i,resultPared[i]);
		}
		for(int i = 0; i < 3; i++) {
			answer += a[i];
		}
		return answer;
	}

	private void cacul(int[] answer,int index ,String[] string) {
		int result = 0;
		result += Integer.parseInt(string[0]);
		if (string[1].equals("S")) {	
			result = (int)Math.pow(result,1);
		}
		if (string[1].equals("D")) {
			result = (int)Math.pow(result,2);
		}
		if (string[1].equals("T")) {
			result = (int)Math.pow(result,3);
		}
		
		if (string[2] != null) {
			if(string[2].equals("*")) {
				if(index != 0) {
					answer[index-1] *= 2;
				}
				result *= 2;
			}
			if(string[2].equals("#")) {
				result *= (-1);
			}
		}
		answer[index] += result;
	}
}