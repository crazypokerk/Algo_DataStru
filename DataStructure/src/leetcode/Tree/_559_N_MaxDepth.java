package leetcode.Tree;

import java.util.*;

/**
 * @Date 2019/8/31 16:23
 */
public class _559_N_MaxDepth {

//	public int maxDepth(Node root) {
//
//		if (root == null) {
//			return 0;
//		}
//
//		int max = 0;
//
//		for (Node child : root.children) {
//			int depth = maxDepth(child);
//			max = Math.max(max, depth);
//		}
//		return max + 1;
//	}
	
	public int maxDepth(Node root) {
		Queue<Node> queue = new LinkedList<>();
		if (root == null) return 0;
		
		queue.add(root);
		
		int max = 0;
		
		while (!queue.isEmpty()) {
			max++;
			int count = queue.size();
			while (count-- > 0) {
				Node now = queue.poll();
				for (Node child : now.children) {
					queue.add(child);
				}
			}
		}
		return max;
	}
	
}
