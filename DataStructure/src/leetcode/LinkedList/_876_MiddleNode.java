package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * @Date 2019/9/2 11:28
 */
public class _876_MiddleNode {
	
	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
}
