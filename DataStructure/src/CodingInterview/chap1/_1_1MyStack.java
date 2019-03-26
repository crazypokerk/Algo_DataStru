package CodingInterview.chap1;


import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 *      实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 要求：
 *      pop、push、getMin操作的时间复杂度都是O（1）
 *      设计的栈类型可以使用现成的栈结构
 * @Date 2019/3/7 8:36
 */
public class _1_1MyStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public _1_1MyStack(int capacity) {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    //1.
    /*public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }*/
    //2.
    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getMin()) {
            this.stackMin.push(newNum);
        } else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
    }

    //1.
    /*public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }*/
    //2.
    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        return this.stackMin.peek();
    }
}
