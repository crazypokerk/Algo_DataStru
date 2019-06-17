package CodingInterview.chap1;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 *
 * @Date 2019/3/7 9:02
 */
public class _1_2TwoStacksQueue {
  private Stack<Integer> stackPush;
  private Stack<Integer> stackPop;

  public _1_2TwoStacksQueue() {
    stackPush = new Stack<>();
    stackPop = new Stack<>();
  }

  public void add(int val) {
    stackPush.push(val);
  }

  public int poll() {
    if (stackPush.empty() && stackPop.empty()) {
      throw new RuntimeException("队列为空！");
    } else if (!stackPop.empty()) {
      while (!stackPush.empty()) {
        stackPop.push(stackPush.pop());
      }
    }
    return stackPop.pop();
  }

  public int peek() {
    if (stackPush.empty() && stackPop.empty()) {
      throw new RuntimeException("队列为空！");
    } else if (!stackPop.empty()) {
      while (!stackPush.empty()) {
        stackPop.push(stackPush.pop());
      }
    }
    return stackPop.pop();
  }
}
