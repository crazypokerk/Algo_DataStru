package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * @Date 2019/9/2 9:45
 */
public class _141_HasCycle {
	
	public boolean hasCycle(ListNode head) {
		
		ListNode slow = head, fast = head.next;
		
		while (slow != fast) {
			if (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			} else {
				return false;
			}
		}
		return true;
	}
	
}
