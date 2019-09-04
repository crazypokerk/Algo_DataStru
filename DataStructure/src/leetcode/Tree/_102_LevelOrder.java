package leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Date 2019/8/21 10:53
 */
public class _102_LevelOrder {
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		
		if (root == null) return result;
		
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				list.add(tmp.val);
				if (tmp.left != null) {
					queue.add(tmp.left);
				}
				if (tmp.right != null) {
					queue.add(tmp.right);
				}
			}
			result.add(list);
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> lists = levelOrder(root);
		
		for (List<Integer> list : lists) {
			System.out.println(list);
		}
	}
}
