package leetcode.Tree;

import java.util.*;

class Node {
	public int val;
	public List<Node> children;
	
	public Node() {
	}
	
	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}

/**
 * @Date 2019/8/31 14:41
 */
public class _429_LevelOrder {
	
	public List<List<Integer>> levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		List<List<Integer>> lists = new ArrayList<>();
		if (root == null) return lists;
		
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int count = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				Node now = queue.poll();
				list.add(now.val);
				for (Node child : now.children) {
					if (child != null) {
						queue.add(child);
					}
				}
			}
			lists.add(list);
		}
		return lists;
	}
	
}
