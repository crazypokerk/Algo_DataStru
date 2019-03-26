package CodingInterview.chap2;

/**
 * 删除链表的中间节点和a/b处的节点
 * @Date 2019/3/9 10:48
 */
public class _2_3RemoveMidNode {
    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }

        Node slow = head;
        Node fast = head.next.next;

        while (slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }

        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        n = (int) (Math.ceil((double) (a * n)) / (double) b);
        if (n == 1) {
            head = head.next;
        }

        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
