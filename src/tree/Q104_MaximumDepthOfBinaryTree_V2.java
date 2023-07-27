package tree;

/**
 * 法二：通过分解问题计算出左右子树的最大深度
 */
public class Q104_MaximumDepthOfBinaryTree_V2 {

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        // 后序位置
        // 一颗子树的最大深度等于左右子树的最大深度取最大值再加上根节点自己
        return Math.max(leftMax, rightMax) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int maxDepth = new Q104_MaximumDepthOfBinaryTree_V2().maxDepth(root);
        System.out.println(maxDepth);
    }

}
