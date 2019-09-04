package leetcode.Top100;

import leetcode.ListNode;

/**
 * @Date 2019/9/4 13:57
 */

public class _234_IsPalindrome {
	
	public boolean isPalindrome(ListNode head) {
		
		if (head == null || head.next == null) return true;
		
		ListNode slow = head;
		ListNode fast = head;
		
		// 1.先找出中点
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// 2.反转前半部分链表
		ListNode pre = null, next = null;
		while (head != slow) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		
		// 3.如果是奇数个，后移一个元素
		if (fast != null) {
			slow = slow.next;
		}
		
		// 4.判断
		while (pre != null) {
			if (slow.val != pre.val) {
				return false;
			}
			slow = slow.next;
			pre = pre.next;
		}
		
		return true;
	}
	
}
