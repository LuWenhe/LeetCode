package tree;

/**
 * 101.对称二叉树
 */
public class Q101_SymmetricTree {

    // 使用分解的方法, 判断左右子树是否相等
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        // 如果p和q指向的结点有一个结点为null,则是不对称的
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean check1 = check(p.left, q.right);
        boolean check2 = check(p.right, q.left);

        return check1 && check2;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 检查根结点的左右两棵子树是否对称
        return check(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        boolean symmetric = new Q101_SymmetricTree().isSymmetric(root);
        System.out.println(symmetric);
    }

}
