package Tree;

public class Q543_DiameterOfBinaryTree_V2 {

    int maxDiameter = 0;

    /**
     *      1
     *   2    3
     * 4   5
     */
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        // 后序位置
        // 计算每个结点的左右子树的最大深度之和
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        // 返回的是每个结点的最大深度
        return Math.max(leftMax, rightMax) + 1;
    }

    private int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);
        int maxDepth = new Q543_DiameterOfBinaryTree_V2().diameterOfBinaryTree(root);
        System.out.println(maxDepth);
    }

}
