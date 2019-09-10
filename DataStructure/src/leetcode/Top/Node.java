package leetcode.Top;

/**
 * @Date 2019/9/8 12:57
 */
public class Node<E> {
	E item;
	Node<E> next;
	Node<E> prev;
	
	Node(Node<E> prev, E element, Node<E> next) {
		this.item = element;
		this.next = next;
		this.prev = prev;
	}
}
