package Tree;

public class Q100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两个结点都为空, 则两个二叉树相同, 直接返回true
        if (p == null && q == null) {
            return true;
        }

        // 如果一个结点为空另一个不为空, 则两个二叉树不同, 直接返回false
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean isLeftSame = isSameTree(p.left, q.left);
        boolean isRightSame = isSameTree(p.right, q.right);

        return isLeftSame && isRightSame;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        boolean sameTree = new Q100_SameTree().isSameTree(root1, root2);
        System.out.println(sameTree);
    }

}
