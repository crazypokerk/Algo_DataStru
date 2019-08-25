package leetcode.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/8/21 15:41
 */
public class _105_BuildTree_pre_in {
	int[] preorder;
	int[] inorder;
	int pre_index = 0;
	Map<Integer, Integer> map = new HashMap<>();
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		this.inorder = inorder;
		
		int index = 0;
		
		for (int num : inorder) {
			map.put(num, index++);
		}
		return helper(0, map.size());
	}
	
	public TreeNode helper(int left_index, int right_index) {
		if (left_index == right_index) {
			return null;
		}
		int root_val = preorder[pre_index];
		TreeNode root = new TreeNode(root_val);
		
		int root_in_index = map.get(root_val);
		
		pre_index++;
		
		root.left = helper(left_index, root_in_index);
		root.right = helper(root_in_index + 1, right_index);
		
		return root;
	}
	
}
