package JianZhiOffer;

//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * pre:前序遍历数组
 * in：中序遍历数组
 */
public class _7_ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null | in == null) {
            return null;
        }
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;

    }

    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i < endIn; i++) {
            if (in[i] == pre[startPre]) {
                /**
                 * 第一次调用reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
                 * 左子树长度 = i - startIn
                 * 右子树长度 = endIn - i
                 *
                 * 根：root = pro[startPre]
                 */
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + (i - startIn), in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, (i - startIn) + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
}
