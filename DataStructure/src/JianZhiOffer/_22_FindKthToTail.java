package JianZhiOffer;

/**
 * @Date 2019/4/2 14:58
 */
public class _22_FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = null;

        for (int i = 0; i < k - 1; i++) {
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                return null;
            }

        }
        p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
