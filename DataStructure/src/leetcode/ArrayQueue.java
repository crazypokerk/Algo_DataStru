package leetcode;

/**
 * @Date 2019/9/13 19:17
 */
public class ArrayQueue {
	private int n = 0;
	private int head = 0;
	private int tail = 0;
	private String[] items;
	
	public ArrayQueue(int capacity) {
		items = new String[capacity];
		n = capacity;
	}
	
	public boolean enqueue(String item) {
		if (tail == n) {
			if (head == 0) {
				return false;
			}
			for (int i = head; i < tail; i++) {
				items[i - head] = items[head];
			}
			tail -= head;
			head = 0;
		}
		items[tail] = item;
		tail++;
		return true;
	}
	
	public String dequeue() {
		if (head == tail) {
			return null;
		}
		String ans = items[head];
		head++;
		return ans;
	}
}
