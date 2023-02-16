package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q144_BinaryTreePreorderTraversal {

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2, new TreeNode(3), null);
        List<Integer> list = new Q144_BinaryTreePreorderTraversal().preorderTraversal(null);
        System.out.println(list);
    }

}
