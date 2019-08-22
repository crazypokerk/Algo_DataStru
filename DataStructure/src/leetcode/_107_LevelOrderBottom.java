package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/8/22 15:06
 */
public class _107_LevelOrderBottom {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		helper(result, root, 0);
		
		return result;
	}
	
	private void helper(List<List<Integer>> result, TreeNode root, int depth) {
		if (root == null) return;
		if (result.size() == depth) result.add(0, new ArrayList<>());
		result.get(result.size() - depth - 1).add(root.val);
		helper(result, root.left, depth + 1);
		helper(result, root.right, depth + 1);
	}
}
