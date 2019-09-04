package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * @Date 2019/9/2 9:09
 */
public class _83_DeleteDuplicates {
	
	public ListNode deleteDuplicates(ListNode head) {
		
		ListNode sentry = head;
		
		while (sentry != null && sentry.next != null) {
			if (sentry.val == sentry.next.val) {
				sentry.next = sentry.next.next;
			} else {
				sentry = sentry.next;
			}
		}
		return head;
	}
	
}
