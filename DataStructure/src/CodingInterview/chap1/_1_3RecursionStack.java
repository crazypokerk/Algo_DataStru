package CodingInterview.chap1;

import java.util.Stack;

/**
 * 如何仅用递归函数和栈操作逆序一个栈？
 * 一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1.将这个栈转置后，
 * 从栈顶到栈底为1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数实现。
 * @Date 2019/3/7 9:18
 */
public class _1_3RecursionStack {
    public static int getAndRemveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }else {
            int last = getAndRemveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
