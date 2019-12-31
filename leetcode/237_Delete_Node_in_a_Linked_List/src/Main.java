
public class Main {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ListNode head = new ListNode(4);
	        ListNode sec = new ListNode(5);
	        ListNode thr = new ListNode(1);
	        ListNode four = new ListNode(9);
	        head.next = sec;
	        sec.next = thr;
	        thr.next = four;
	        
	        sec = sec.next;
	        
	        System.out.println(head.next.val);
	        System.out.println(sec.val);
	}

}
