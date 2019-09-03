import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Solution.FileInfo;

public class Main {
	public static void main(String[] args) {
		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String[] answer = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].toLowerCase();
			String h = null;
			String n = null;
			int startNum = 0;
			for (int j = 0; j < fileName.length(); j++) {

				if (h == null && Character.isDigit(fileName.charAt(j))) {
					
					h = fileName.substring(0, j);
					startNum = j;
					System.out.println(h);
				}
				if (h != null && !Character.isDigit(fileName.charAt(j))) {
					n = fileName.substring(startNum, j);
					System.out.println(n);
					break;
					
				}
				
				
			}		
		}
	}
}
