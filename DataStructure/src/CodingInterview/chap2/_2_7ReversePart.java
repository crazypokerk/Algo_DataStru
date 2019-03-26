package CodingInterview.chap2;

/**
 * @Date 2019/3/9 13:50
 */
public class _2_7ReversePart {
    public Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPre = null;  //要反转部分的前一个节点
        Node tPos = null;  //要反转部分的后一个节点
        while (node1 != null) {
            len++;
            fPre = (len == from - 1 ? node1 : fPre);
            tPos = (len == to + 1 ? node1 : tPos);
        }

        if (from > to || from < 1 || to > len) {
            return head;
        }

        node1 = fPre == null ? head : fPre.next;

        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;

        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
