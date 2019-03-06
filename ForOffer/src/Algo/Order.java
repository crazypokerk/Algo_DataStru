package Algo;

public class Order {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root);
        inOrder(root.right);
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root);
    }
}
