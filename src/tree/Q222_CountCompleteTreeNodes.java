package tree;

/**
 * 222.完全二叉树的结点个数
 */
public class Q222_CountCompleteTreeNodes {

    // 通过分解问题计算出左右子树的结点个数
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTreeCount = countNodes(root.left);
        int rightTreeCount = countNodes(root.right);
        return leftTreeCount + rightTreeCount + 1;
    }

    public int countNodes2(TreeNode root) {
        TreeNode l = root, r = root;
        int lh = 0, rh = 0;

        while (l != null) {
            l = l.left;
            lh++;
        }

        while (r != null) {
            r = r.right;
            rh++;
        }

        // 如果左右子树的高度相同, 则是一棵满二叉树
        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        }

        int leftNodes = countNodes2(root.left);
        int rightNodes = countNodes2(root.right);

        return leftNodes + rightNodes + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3, new TreeNode(6), null);
        int countNodes = new Q222_CountCompleteTreeNodes().countNodes2(root);
        System.out.println(countNodes);
    }

}
