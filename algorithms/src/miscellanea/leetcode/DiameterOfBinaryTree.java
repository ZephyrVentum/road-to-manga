package miscellanea.leetcode;

import utils.TreeNode;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(new TreeNode(2)));
    }

    int length = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return length;
    }

    private int dfs(TreeNode root) {
        int left = 0;
        if (root.left != null) {
            left = dfs(root.left) + 1;
        }
        int right = 0;
        if (root.right != null) {
            right = dfs(root.right) + 1;
        }
        if (left + right > length) {
            length = left + right;
        }
        return Math.max(left, right);
    }
}
