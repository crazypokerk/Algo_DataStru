package leetcode.Design;

import java.util.Stack;

/**
 * @Date 2019/9/1 15:57
 */
public class MinStack {
	
	private Stack<Integer> stack;
	private Stack<Integer> min_stack;
	
	public MinStack() {
		stack = new Stack<>();
		min_stack = new Stack<>();
	}
	
	public void push(int x) {
		stack.push(x);
		if (min_stack.isEmpty() || x <= min_stack.peek()) {
			min_stack.push(x);
		} else {
			min_stack.push(min_stack.peek());
		}
	}
	
	public void pop() {
		if (!stack.isEmpty()) {
			min_stack.pop();
			stack.pop();
		}
	}
	
	public int top() {
		if (!stack.isEmpty()) {
			return stack.peek();
		}
		throw new RuntimeException("");
	}
	
	public int getMin() {
		if (!min_stack.isEmpty()) {
			return min_stack.peek();
		}
		throw new RuntimeException("");
	}
}
