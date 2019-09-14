package leetcode.Tree;


import java.util.LinkedList;
import java.util.List;

/**
 * @Date 2019/8/31 16:20
 */
public class _145_PostorderTraversal {
	
	public List<Integer> postorderTraversal(TreeNode root) {
		
		LinkedList<TreeNode> list = new LinkedList<>();
		LinkedList<Integer> ans = new LinkedList<>();
		if (root == null) return ans;
		
		list.add(root);
		
		while (!list.isEmpty()) {
			TreeNode cur = list.pollLast();
			ans.addFirst(cur.val);
			if (cur.left != null) {
				list.add(cur.left);
			}
			if (cur.right != null) {
				list.add(cur.right);
			}
		}
		return ans;
	}
	
}
