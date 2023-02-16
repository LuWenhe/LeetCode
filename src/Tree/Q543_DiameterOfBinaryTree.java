package Tree;

public class Q543_DiameterOfBinaryTree {

    int maxDiameter = 0;

    // 每个结点的最大深度
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

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 计算每个结点的直径, 即一个结点的左右子树的最大深度之和
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int myDiameter = leftMax + rightMax;

        // 更新获得最大直径
        maxDiameter = Math.max(maxDiameter, myDiameter);

        traverse(root.left);
        traverse(root.right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);
        int maxDepth = new Q543_DiameterOfBinaryTree().diameterOfBinaryTree(root);
        System.out.println(maxDepth);
    }

}
