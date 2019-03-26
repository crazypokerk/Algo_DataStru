package CodingInterview.chap2;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * @Date 2019/3/11 17:13
 */
public class _2_9IsPalindrome {
    //方法1
    public boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //方法2
    public boolean isPalindrome2(Node head) {
        if (head == null | head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;

        //快慢指针定位中点
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }

        Stack<Node> stack = new Stack<>();

        while (right != null) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //方法3
    public boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node n1 = head;
        Node n2 = head;
        while (n1.next != null && n2.next.next != null) {
            n1 = n1.next;       //n1 -> 中部
            n2 = n2.next.next;  //n2 -> 结尾
        }

        n2 = n1.next;
        n1.next = null;

        //反转右半部分
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        n3 = n1;
        n2 = head;

        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        //恢复链表
        n1 = n3.next;
        n3.next = null;

        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }
}
