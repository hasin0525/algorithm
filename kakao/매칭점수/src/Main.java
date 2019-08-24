import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "aba";
		String page = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				"<head>\r\n" + 
				"  <meta charset=\"utf-8\">\r\n" + 
				"  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\r\n" + 
				"</head>  \r\n" + 
				"<body>\r\n" + 
				"aba@aba aba\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
		
		String pName = "";
		LinkedList<String> pLinkList = new LinkedList<>();
		int pBasicScore = 0;
		int pOutLinkScore = 0;
		
		Matcher m = Pattern.compile("(<meta property=\"og:url\" content=\")(.+)(\")").matcher(page);
		while (m.find()) {
			pName = m.group(2);
		}
		
		String body = "";
		m = Pattern.compile("(<body>)(.+)(</body>)", Pattern.DOTALL).matcher(page);
		while (m.find()) {
			body = m.group(2);
		}

		m = Pattern.compile("(a href=\")(.+)(\">)").matcher(body);
		while (m.find()) {
			pLinkList.add(m.group(2));
		}
		pOutLinkScore = pLinkList.size();

		// 마지막으로 검색어를 파싱해야한다. a 링크 안에 들어있는 것은 포함하면 안된다.?
		String template = "(?i)[^a-zA-Z]%s[^a-zA-Z]";
		String regExp = String.format(template, word);
		m = Pattern.compile(regExp).matcher(body);
		while (m.find()) {
			pBasicScore += 1;
		}
		
		System.out.println(pBasicScore);
		System.out.println(pOutLinkScore);
	}

}
