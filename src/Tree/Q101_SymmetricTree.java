package Tree;

public class Q101_SymmetricTree {

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

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
