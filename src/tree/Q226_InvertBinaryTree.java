package tree;
import java.util.ArrayList;
import java.util.List;

/**
 * 226.翻转二叉树
 */
public class Q226_InvertBinaryTree {

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        // 前序遍历的位置
        // 交换当前结点的左右结点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
    }

    // 通过遍历二叉树的方式, 使用traverse()函数
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
        TreeNode rootNew = new Q226_InvertBinaryTree().invertTree(root);

        List<Integer> list = new ArrayList<>();
        new Q226_InvertBinaryTree().preorder(rootNew, list);
        System.out.println(list);
    }

}
