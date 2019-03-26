package CodingInterview.chap3;

/**
 * 判断二叉树是否为平衡二叉树
 *
 * @Date 2019/3/16 14:58
 */
public class _3_P144IsBalance {
    public boolean isBalance(TreeNode head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public int getHeight(TreeNode head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }

        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }
}
