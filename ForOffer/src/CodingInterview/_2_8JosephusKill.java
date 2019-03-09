package CodingInterview;

/**
 * 环形单链表的约瑟夫问题
 * @Date 2019/3/9 14:42
 */
public class _2_8JosephusKill {
    public Node josephusKill(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }

        Node last = head;
        while (last.next != head) {
            last = last.next;
        }

        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
            }else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }
}
