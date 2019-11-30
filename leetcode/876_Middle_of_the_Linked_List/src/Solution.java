/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode answer = head;
        while(answer != null) {
        	answer = answer.next;
        	count++;
        }
        
        int mid = count / 2;
        answer = head;
        for(int i = 0; i < mid; i++) {
        	answer = answer.next;
        }
        return answer;
    }
}