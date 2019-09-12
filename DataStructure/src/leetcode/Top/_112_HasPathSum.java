package leetcode.Top;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Date 2019/9/11 16:25
 */
public class _112_HasPathSum {
	
	public boolean hasPathSum(TreeNode root, int sum) {
		
		if (root == null) return false;
		sum -= root.val;
		if (root.left == null && root.right == null) return sum == 0;
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}
	
	public boolean hasPathSumBFS(TreeNode root, int sum) {
		
		if (root == null) return false;
		
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Integer> values = new LinkedList<>();
		
		nodes.offer(root);
		values.offer(root.val);
		
		while (!nodes.isEmpty()) {
			int size = nodes.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = nodes.poll();
				int cur_sum = values.poll();
				if (cur != null) {
					if ((cur.left == null) && (cur.right == null) && cur_sum == sum) {
						return true;
					}
					if (cur.left != null) {
						nodes.offer(cur.left);
						values.offer(cur_sum + cur.left.val);
					}
					if (cur.right != null) {
						nodes.offer(cur.right);
						values.offer(cur_sum + cur.right.val);
					}
				}
			}
		}
		return false;
	}
}
