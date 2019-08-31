

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		ZonedDateTime zdt2 = ZonedDateTime.parse("2002-06-18 01:00:04.001 KST", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS z"));
		String a = "2016-09-15 21:00:00.748 2.31s";
		System.out.println(a.substring(0,24));
		System.out.println(a.substring(24,25));
		//System.out.println(zdt2);
	}

}
