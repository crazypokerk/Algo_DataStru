/**
 * @Date 2019/7/5 15:35
 */
public class Treeeee {
	
	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(0);
		root.left = new TreeNode1(1);
		root.right = new TreeNode1(2);
		
		TreeNode1 tmp = root.left;
		
		tmp.left = new TreeNode1(4);
		tmp.right = new TreeNode1(5);
	}
}

class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;
	
	TreeNode1(int x) {
		val = x;
	}
}
