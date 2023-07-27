package tree;

/**
 * 法一：通过遍历二叉树的方式,需要外部函数traverse
 */
public class Q104_MaximumDepthOfBinaryTree {

    // 记录最大深度
    int maxDepth = 0;
    // 记录当前遍历到的节点所在的深度
    int curDepth = 0;

    // 二叉树遍历框架
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序位置
        // 进入一个结点的时候结点深度加1
        curDepth++;

        // 到达叶子节点，更新最大深度
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, curDepth);
        }

        traverse(root.left);
        traverse(root.right);

        // 后序位置
        // 离开一个结点的时候结点深度减1
        curDepth--;
    }

    // 主函数
    int maxDepth(TreeNode root) {
        traverse(root);
        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        int maxDepth = new Q104_MaximumDepthOfBinaryTree().maxDepth(root);
        System.out.println(maxDepth);
    }

}
