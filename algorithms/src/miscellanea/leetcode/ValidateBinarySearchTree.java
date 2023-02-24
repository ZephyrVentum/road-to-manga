package miscellanea.leetcode;

import utils.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Integer[] tree = new Integer[]{3,1,5,0,2,4,6,null,null,null,3};
//        TreeNode treeNode = TreeNode.newTree(tree);
        TreeNode treeNode = new TreeNode(98, new TreeNode(-57, null, new TreeNode(58, new TreeNode(31), null)), null);
        System.out.println(new ValidateBinarySearchTree().isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

}
