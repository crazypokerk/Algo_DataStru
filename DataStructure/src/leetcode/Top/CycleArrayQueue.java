package leetcode.Top;

/**
 * @Date 2019/9/13 19:52
 */
public class CycleArrayQueue {
	
	private int n = 0;
	private int head = 0;
	private int tail = 0;
	private String[] items;
	
	public CycleArrayQueue(int capacity) {
		items = new String[capacity];
		n = capacity;
	}
	
	public boolean enqueue(String item) {
		if ((tail + 1) % n == head) {
			return false;
		}
		items[tail] = item;
		tail = (tail + 1) % n;
		return true;
	}
	
	public String dequeue() {
		if (head == tail) {
			return null;
		}
		String ans = items[head];
		head = (head + 1) % n;
		return ans;
	}
}
