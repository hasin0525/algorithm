import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Page {
	int index;
	String name;
	LinkedList<String> linkList;
	int basicScore;
	int outLinkScore;
	double linkScore;
	double matchingScore;

	public Page(int index, String name, LinkedList<String> linkList, int basicScore, int outLinkScore) {
		super();
		this.index = index;
		this.name = name;
		this.linkList = linkList;
		this.basicScore = basicScore;
		this.outLinkScore = outLinkScore;
		this.linkScore = 0;
		this.matchingScore = 0;
	}
	
	

	@Override
	public String toString() {
		return "Page [index=" + index + ", name=" + name + ", basicScore=" + basicScore + ", outLinkScore="
				+ outLinkScore + ", linkScore=" + linkScore + ", matchingScore=" + matchingScore + "]";
	}



	static Comparator<Page> com = new Comparator<Page>() {
		public int compare(Page p1, Page p2) {
			if (p1.matchingScore < p2.matchingScore) {
				return 1;
			} else if (p1.matchingScore == p2.matchingScore) {
				return p1.index - p2.index;
			} else {
				return -1;
			}
		}
	};
}

class Solution {

	public void parsingPage(String word, String page, int index, ArrayList<Page> pagelist,
			HashMap<String, Integer> nameToIndex) {
		// page 문자열을 파싱해서 index, name, linklist, basicScore, outLinkScore를 만들어서 넣는다.

		int pIndex = index;
		String pName = "";
		LinkedList<String> pLinkList = new LinkedList<>();
		int pBasicScore = 0;
		int pOutLinkScore = 0;

		Matcher m = Pattern.compile("(<meta property=\"og:url\" content=\")(.+)(\")").matcher(page);
		while (m.find()) {
			pName = m.group(2);
		}

		nameToIndex.put(pName, pIndex);

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
		word = word.toLowerCase();
		body = body.toLowerCase();
		for(int i = body.indexOf(word, 0); ;) {
			if(i == -1) {
				break;
			}
			if(!Character.isLetter(body.charAt(i-1)) && !Character.isLetter(body.charAt(i+ word.length()))) {
				pBasicScore += 1;
			}
			i = body.indexOf(word, i+word.length());
		}

		pagelist.add(new Page(pIndex, pName, pLinkList, pBasicScore, pOutLinkScore));
	}

	public void setLinkScore(HashMap<String, Integer> nameToIndex, ArrayList<Page> pagelist) {
		for (Page p : pagelist) {
			for (String link : p.linkList) {
				// 외부링크가 입력한 페이지를 벗어나는 경우도 있다.
				if(nameToIndex.containsKey(link)) {
					pagelist.get(nameToIndex.get(link)).linkScore += ((double) p.basicScore / (double) p.outLinkScore);
				}
			}
		}
	}

	public void setMatchingScore(ArrayList<Page> pagelist) {
		for (Page p : pagelist) {
			p.matchingScore = p.basicScore + p.linkScore;
		}
	}

	public int solution(String word, String[] pages) {
		HashMap<String, Integer> nameToIndex = new HashMap<>();
		ArrayList<Page> pagelist = new ArrayList<>();
		for (int i = 0; i < pages.length; i++) {
			parsingPage(word, pages[i], i, pagelist, nameToIndex);
		}

		// 링크스코어를 구한다.
		setLinkScore(nameToIndex, pagelist);
		// 매칭 스코어를 구한다.
		setMatchingScore(pagelist);
		Collections.sort(pagelist, Page.com);
		
		return pagelist.get(0).index;
	}
}