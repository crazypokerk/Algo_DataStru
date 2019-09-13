package leetcode;

/**
 * @Date 2019/9/13 14:18
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		// 找到中点位置
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		
		// 反转后半部分
		ListNode second = slow.next;
		
		// 置空slow的指向
		slow.next = null;
		
		second = reverseList(second);
		
		ListNode first = head;
		
		ListNode next1, next2;
		while (second != null) {
			next1 = first.next;
			next2 = second.next;
			
			first.next = second;
			second.next = next1;
			
			first = next1;
			second = next2;
		}
	}
	
	private ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
