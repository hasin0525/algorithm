import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String[] parse = new String[3];
		Pattern p = Pattern.compile("(([0-9]|[0-9]{2}?)[STD][*#]?)");
		Matcher m = p.matcher("1D2S3T*");
		int index = 0;
		while (m.find()) {
			parse[index] = m.group(1);
			index++;
		}

		String[][] resultPared = new String[3][3];
		for (int i = 0; i < 3; i++) {
			p = Pattern.compile("([0-9]?[10]?)([S|T|D])([*|#]?)");
			m = p.matcher(parse[i]);
			while (m.find()) {
				resultPared[i][0] = m.group(1);
				resultPared[i][1] = m.group(2);
				if (m.group(3) != null) {
					resultPared[i][2] = m.group(3);
				}
			}
		}

		System.out.println(resultPared[0][0]);
		System.out.println(resultPared[0][1]);
		System.out.println(resultPared[1][0]);
		System.out.println(resultPared[1][1]);
		System.out.println(resultPared[2][0]);
		System.out.println(resultPared[2][1]);
		System.out.println(resultPared[2][2]);
	}

}
