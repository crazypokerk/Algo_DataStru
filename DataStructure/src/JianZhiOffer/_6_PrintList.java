package JianZhiOffer;

import java.util.ArrayList;

/**
 * @Date 2019/3/22 15:41
 */
public class _6_PrintList {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return arrayList;
        }
        printListFromTailToHead(listNode.next);
        arrayList.add(listNode.val);
        return arrayList;
    }


}
