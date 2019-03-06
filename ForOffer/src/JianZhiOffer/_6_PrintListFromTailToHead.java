package JianZhiOffer;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class _6_PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /*if (listNode != null) {
            if (listNode.next != null) {
                printListFromTailToHead(listNode.next);
            }
            System.out.println(listNode.next.val);
        }*/

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (arrayList == null) {
            return arrayList;
        }if (listNode.next != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public ArrayList<Integer> arrayList(ListNode listNode) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        ListNode head = listNode;
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }

        while (!s.empty()) {
            list.add(s.pop());
        }
        return list;
    }
}
