package JianZhiOffer;

/**
 * @Date 2019/4/2 15:29
 */

public class _26_HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (Equal(root1.val, root2.val)) {
                result = DoesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (!Equal(root1.val, root2.val)) {
            return false;
        }
        return DoesTree1HaveTree2(root1.left, root2.left) &&
                DoesTree1HaveTree2(root1.right, root2.right);
    }

    public boolean Equal(double n1, double n2) {
        if ((n1 - n2 > -0.0000001) && (n1 - n2 < 0.0000001)) {
            return true;
        } else {
            return false;
        }
    }

    static class TreeNode{
        double val;
        TreeNode left;
        TreeNode right;
    }
}
