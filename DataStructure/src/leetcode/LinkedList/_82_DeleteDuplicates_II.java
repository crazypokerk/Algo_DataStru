package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * @Date 2019/9/2 9:22
 */
public class _82_DeleteDuplicates_II {
	
	public ListNode deleteDuplicates(ListNode head) {
		
		ListNode new_list = new ListNode(-1);
		ListNode p = new_list, sentry = head;
		
		while (sentry != null) {
			int count = 1;
			while (sentry.next != null && sentry.val == sentry.next.val) {
				sentry = sentry.next;
				count++;
			}
			
			if (count == 1) {
				p.next = sentry;
				p = p.next;
			}
			sentry = sentry.next;
		}
		
		p.next = null;
		return new_list.next;
	}
	
}
