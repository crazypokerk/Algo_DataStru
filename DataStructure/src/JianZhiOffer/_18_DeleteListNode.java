package JianZhiOffer;

/**
 * 删除链表节点
 *
 * @Date 2019/3/28 17:42
 */
public class _18_DeleteListNode {
    public void deleteListNode(Node head, Node toBeDelete) {
        if (head == null || toBeDelete == null) {
            return;
        }

        if (toBeDelete.next != null) {
            toBeDelete.value = toBeDelete.next.value;
            toBeDelete.next = toBeDelete.next.next;
        } else if (head == toBeDelete) {
            head = head.next;
            toBeDelete = null;
        } else {
            Node p = head;
            while (p.next != toBeDelete) {
                p = p.next;
            }
            p.next = null;
            toBeDelete = null;
        }
    }
}
