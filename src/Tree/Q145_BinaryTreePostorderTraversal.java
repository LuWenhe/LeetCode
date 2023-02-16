package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q145_BinaryTreePostorderTraversal {

    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2, new TreeNode(3), null);
        List<Integer> list = new Q145_BinaryTreePostorderTraversal().postorderTraversal(root);
        System.out.println(list);
    }

}
