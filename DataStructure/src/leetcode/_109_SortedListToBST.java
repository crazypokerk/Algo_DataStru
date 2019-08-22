package leetcode;

/**
 * @Date 2019/8/22 16:38
 */
class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
	}
}

public class _109_SortedListToBST {
	ListNode head;
	
	private int countSize(ListNode head) {
		
		ListNode tmp = head;
		int count = 0;
		while (tmp != null) {
			count++;
			tmp = tmp.next;
		}
		return count;
	}
	
	private TreeNode convert(int start, int end) {
		if (start > end) return null;
		
		int mid = (start + end) >> 1;
		
		TreeNode left = convert(1, mid - 1);
		TreeNode root = new TreeNode(head.val);
		root.left = left;
		
		head = head.next;
		
		root.right = convert(mid + 1, end);
		
		return root;
	}
	
	public TreeNode sortedListToBST1(ListNode head) {
		
		int size = countSize(head);
		
		this.head = head;
		
		return convert(0, size - 1);
		
	}
	
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		
		return helper(head, null);
		
	}
	
	public TreeNode helper(ListNode head, ListNode tail) {
		if (head == tail) return null;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != tail && fast.next.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		TreeNode root = new TreeNode(slow.val);
		root.left = helper(head, slow);
		root.right = helper(slow.next, tail);
		return root;
	}
	
}
