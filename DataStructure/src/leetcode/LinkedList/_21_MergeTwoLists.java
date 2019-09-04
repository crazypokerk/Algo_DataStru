package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * @Date 2019/9/2 8:45
 */

public class _21_MergeTwoLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode new_list = new ListNode(-1);
		
		ListNode sentry = new_list;
		
		while (l1 != null && l2 != null) {
			if (l1.val >= l2.val) {
				sentry.next = l2;
				l2 = l2.next;
			} else {
				sentry.next = l1;
				l1 = l1.next;
			}
			sentry = sentry.next;
		}
		
		sentry.next = l1 == null ? l2 : l1;
		
		return new_list.next;
	}
	
}
