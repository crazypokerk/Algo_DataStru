package leetcode.Top;

import leetcode.ListNode;

/**
 * @Date 2019/9/7 14:31
 */
public class _19_RemoveNthFromEnd {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode help = new ListNode(-1);
		help.next = head;
		ListNode slow = help, fast = help;
		
		while (n-- > 0) {
			fast = fast.next;
		}
		
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		slow.next = slow.next.next;
		
		return help.next;
	}
	
}
