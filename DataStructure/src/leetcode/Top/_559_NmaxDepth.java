package leetcode.Top;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Date 2019/9/14 15:20
 */
public class _559_NmaxDepth {
	
	public int maxDepth(Node root) {
		if (root == null) return 0;
		int max = 0;
		for (Node child : root.children) {
			int dep = maxDepth(child);
			max = Math.max(dep, max);
		}
		return max + 1;
	}
	
	public int maxDepth1(Node root) {
		Queue<Node> queue = new LinkedList<>();
		if (root == null) return 0;
		queue.offer(root);
		int max = 0;
		
		while (!queue.isEmpty()) {
			int count = queue.size();
			max++;
			while (count-- > 0) {
				Node cur = queue.poll();
				for (Node child : cur.children) {
					queue.add(child);
				}
			}
		}
		return max;
	}
	
	
	private static class Node {
		public int val;
		public List<Node> children;
		
		public Node() {
		}
		
		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
}
