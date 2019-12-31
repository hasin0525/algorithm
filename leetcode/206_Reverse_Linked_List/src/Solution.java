/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(head != null) {
        	cur = head;
        	head = head.next;
        	cur.next = prev;
        	prev = cur;
        }
        return prev;
    }
}