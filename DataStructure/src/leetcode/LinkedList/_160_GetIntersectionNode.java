package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * @Date 2019/9/2 10:28
 */
public class _160_GetIntersectionNode {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		ListNode pA = headA, pB = headB;
		while (pA != pB) {
			pA = (pA == null ? headB : pA.next);
			pB = (pB == null ? headA : pB.next);
		}
		return pA;
	}
	
}
