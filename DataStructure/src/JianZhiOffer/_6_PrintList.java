package JianZhiOffer;

/**
 * @Date 2019/3/22 15:41
 */
public class _6_PrintList {
    public void printList(Node head) {

        if (head != null) {
            if (head.next != null) {
                printList(head.next);
            }

            System.out.println(head.value);
        }
    }
}
