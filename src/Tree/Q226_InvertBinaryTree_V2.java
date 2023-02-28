package Tree;

public class Q226_InvertBinaryTree_V2 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 利用函数定义，先翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 然后交换左右子节点
        root.left = right;
        root.right = left;

        // 和定义逻辑自恰：以 root 为根的这棵二叉树已经被翻转，返回 root
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode treeNode = new Q226_InvertBinaryTree_V2().invertTree(root);
        System.out.println(treeNode.val + " " + treeNode.left.val + " " + treeNode.right.val);
    }

}
