package CodingInterview.chap2;

/**
 * 打印两个有序链表地公共部分
 *
 * @Date 2019/3/8 19:51
 */
class _2_PrintCommonPart {
    public void printCommonPart(Node head1, Node head2) {
        while (head1.next != null || head2.next != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            }else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}

class Node{
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }
}
