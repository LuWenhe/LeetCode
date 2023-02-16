package Tree;

import java.util.*;

public class Q94_BinaryTreeInorderTraversal {

    // 中序遍历
    public void inorder(TreeNode root, List<Integer> list) {
        // 遇到空结点返回上一层
        if (root == null) {
            return;
        }

        // 递归左结点
        inorder(root.left, list);
        // 得到根结点
        list.add(root.val);
        // 递归右结点
        inorder(root.right, list);
    }

    /**
     * 使用递归的方式
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    /**
     * 使用迭代的方式
     * <p>
     * 1.建立一个栈
     * 2.根结点进栈，遍历左子树
     * 3.根结点出栈，输出根结点，遍历右子树
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || stack.size() > 0) {
            // 往左子树方向走, 每走一次就将当前结点保存在栈中
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 如果当前结点为空, 说明左边结点走到尽头了, 从栈中弹出结点并保存
            root = stack.pop();
            res.add(root.val);
            // 然后转向右结点
            root = root.right;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2, new TreeNode(3), null);

        List<Integer> list = new Q94_BinaryTreeInorderTraversal().inorderTraversal2(root);
        System.out.println(list);
    }

}
