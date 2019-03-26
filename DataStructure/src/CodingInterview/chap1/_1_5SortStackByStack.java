package CodingInterview.chap1;

import java.util.Stack;

/**
 * 一个栈中元素的类型为整形，现在想将该栈从顶到底按从小到大的顺序排序，只许申请一个栈。
 * 除此之外，可以申请新的变量，但不能申请额外的数据结构。
 * @Date 2019/3/7 10:15
 */
public class _1_5SortStackByStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            //要是help栈中的元素小于临时变量，那么就把help栈中的元素取出放回stack
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}

