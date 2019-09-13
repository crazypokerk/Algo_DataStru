package leetcode.Top;

import leetcode.ListNode;

/**
 * @Date 2019/9/13 12:33
 */
public class _92_ReverseBetween {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		
		if (head == null) return null;
		
		ListNode cur = head, pre = null;
		while (m > 1) {
			pre = cur;
			cur = cur.next;
			m--;
			n--;
		}
		ListNode start = pre, end = cur;
		
		ListNode next = null;
		while (n > 0) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			n--;
		}
		
		if (start != null) {
			start.next = pre;
		} else {
			head = pre;
		}
		
		end.next = cur;
		return head;
	}
	
}
