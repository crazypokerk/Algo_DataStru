package leetcode.Top;

import leetcode.ListNode;

/**
 * @Date 2019/9/5 9:23
 */
public class _2_AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode sentry = new ListNode(-1);
		ListNode tmp = sentry;
		int carry = 0;
		
		while (l1 != null || l2 != null) {
			int a = l1 == null ? 0 : l1.val;
			int b = l2 == null ? 0 : l2.val;
			
			int sum = a + b + carry;
			
			carry = sum / 10;
			sum %= 10;
			tmp.next = new ListNode(sum);
			
			tmp = tmp.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry == 1) {
			tmp.next = new ListNode(carry);
		}
		return sentry.next;
	}
	
}
