package leetcode.Top;

/**
 * @Date 2019/9/8 12:57
 */
public class RemoveListElement {
	Node first;
	Node last;
	
	public boolean remove(Node x) {
		Node prev = x.prev;
		Node next = x.next;
		
		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			x.prev = null;
		}
		
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}
		
		x.item = null;
		
		return true;
	}
}
