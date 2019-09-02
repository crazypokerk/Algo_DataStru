package leetcode.LinkedList;

/**
 * @Date 2019/9/2 10:53
 */
public class _203_RemoveElements {
	
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) return null;
		
		ListNode tmp = new ListNode(val + 1);
		tmp.next = head;
		ListNode sentry = tmp;
		
		
		while (sentry.next != null) {
			if (sentry.next.val == val) {
				sentry.next = sentry.next.next;
			} else {
				sentry = sentry.next;
			}
		}
		return tmp.next;
	}
	
}
