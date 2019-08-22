import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Date 2019/4/28 16:30
 */
public class BFSDFS {
	public List<List<Integer>> levelOrderBFS(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			int levelSize = q.size();
			List<Integer> currLevel = new ArrayList<>();
			
			for (int i = 0; i < levelSize; i++) {
				TreeNode currNode = q.poll();
				currLevel.add(currNode.val);
				if (currNode.left != null) {
					q.add(currNode.left);
				}
				if (currNode.right != null) {
					q.add(currNode.right);
				}
			}
			res.add(currLevel);
		}
		return res;
	}
	
	public List<List<Integer>> levelOrderDFS(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		dfs(root, res, 0);
		return res;
	}
	
	public void dfs(TreeNode root, List<List<Integer>> res, int level) {
		if (root == null) {
			return;
		}
		if (res.size() < level + 1) {
			res.add(new ArrayList<Integer>());
		}
		res.get(level).add(root.val);
		dfs(root.left, res, level + 1);
		dfs(root.right, res, level + 1);
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		
		gdfs(n, n, "", res);
		return res;
		
	}
	
	public void gdfs(int left, int right, String sublist, List<String> res) {
		if (left == 0 && right == 0) {
			res.add(sublist);
			return;
		}
		
		if (left > 0) {
			gdfs(left - 1, right, sublist + "(", res);
		}
		
		if (right > left) {
			gdfs(left, right - 1, sublist + ")", res);
		}
	}
	
	
}

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
