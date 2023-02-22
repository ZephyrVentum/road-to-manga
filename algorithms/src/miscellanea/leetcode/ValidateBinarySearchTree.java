package miscellanea.leetcode;

import utils.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Integer[] tree = new Integer[]{3, 1, 5, 0, 2, 4, 6};
        TreeNode treeNode = TreeNode.arrayToTree(tree);
        System.out.println(new ValidateBinarySearchTree().isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, root);
    }

    public boolean dfs(TreeNode root, TreeNode startingVertex) {
        boolean answer = true;
        if (root.left != null) {
            if (root.left.val < root.val && (root.left == startingVertex.left || root.left.val > startingVertex.left.val)) {
                if (startingVertex == null){

                }
                answer &= dfs(root.left, startingVertex);
            } else {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val > root.val && (root.right == startingVertex.right || root.right.val < startingVertex.right.val)) {
                answer &= dfs(root.right, startingVertex);
            } else {
                return false;
            }
        }
        return answer;
    }
}
