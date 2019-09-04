package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * @Date 2019/9/2 11:02
 */
public class _206_ReverseList {
	
	public ListNode reverseList(ListNode head) {
		
		ListNode prev = null;
		ListNode next = null;
		
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
}
