package leetcode.LinkedList;

/**
 * @Date 2019/9/2 11:10
 */
public class _234_IsPalindrome {
	
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode pre = null;
		ListNode next = null;
		while (head != slow) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		// 如果是奇数个节点，去除最中间的节点
		if (fast != null) {
			slow = slow.next;
		}
		while (pre != null) {
			if (pre.val != slow.val) {
				return false;
			}
			pre = pre.next;
			slow = slow.next;
		}
		return true;
	}
	
}
