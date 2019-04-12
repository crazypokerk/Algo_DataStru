package JianZhiOffer;

/**
 * @Date 2019/4/2 15:11
 */
public class _23_EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode slow = pHead;
        ListNode fast = pHead;

        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                if (slow == fast) {
                    return slow;
                }
            }
        }
        return null;
    }
}
