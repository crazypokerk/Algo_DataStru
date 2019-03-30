package JianZhiOffer;

/**
 * @Date 2019/3/29 20:13
 */
public class _52_FindFirstCommonNode {
    public Node findFirstCommonNode(Node pHead1, Node pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int len1 = 0, len2 = 0;
        Node p1 = pHead1, p2 = pHead2;
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }

        int tmp = Math.abs(len1 - len2);
        if (len1 > len2) {
            p1 = pHead1;
            p2 = pHead2;
            for (int i = 0; i < tmp; i++) {
                p1 = p1.next;
            }
        } else {
            p2 = pHead2;
            p1 = pHead1;
            for (int i = 0; i < tmp; i++) {
                p2 = p2.next;
            }
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
