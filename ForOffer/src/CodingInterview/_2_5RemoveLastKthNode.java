package CodingInterview;

/**
 * 在单链表和双链表中删除倒数第K个节点
 * 分别实现两个函数，一个可以删除单链表中倒数第K个节点，另一个可以删除双链表
 * 中倒数第K个节点。
 *
 * @Date 2019/3/8 19:57
 */
public class _2_RemoveLastKthNode {
    public Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }

        Node cur = head;

        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }

        if (lastKth == 0) {
            head = head.next;
        }

        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }

        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }

        if (lastKth == 0) {
            head = head.next;
        }

        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        //return head意思是返回这个链表
        return head;
    }
}

class DoubleNode{
    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int data) {
        this.value = data;
    }
}
