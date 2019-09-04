package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * @Date 2019/9/2 9:45
 */
public class _142_HasCycle_II {
	
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) return null;
		
		ListNode slow = head, fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) {
				slow = head;
				while (slow != fast) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
	
}
