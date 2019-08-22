package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/8/22 11:43
 */
public class _106_BuildTree_in_post {
	
	int[] inorder;
	int[] postorder;
	int post_index;
	
	Map<Integer, Integer> map = new HashMap<>();
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.inorder = inorder;
		this.postorder = postorder;
		
		post_index = postorder.length - 1;
		
		if (inorder == null) return null;
		
		int index = inorder.length - 1;
		
		for (int num : inorder) {
			map.put(num, index--);
		}
		
		return helper(0, map.size());
	}
	
	public TreeNode helper(int left_index, int right_index) {
		
		if (left_index == right_index) return null;
		
		int root_val = postorder[post_index--];
		TreeNode root = new TreeNode(root_val);
		
		int root_in_index = map.get(root_val);
		
		root.right = helper(left_index, root_in_index);
		root.left = helper(root_in_index + 1, right_index);
		
		return root;
	}
	
}
