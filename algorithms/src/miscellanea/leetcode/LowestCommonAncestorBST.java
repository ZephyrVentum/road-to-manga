package miscellanea.leetcode;

import utils.TreeNode;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        Integer[] tree = new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode treeNode = TreeNode.newTree(tree);
        System.out.println(new LowestCommonAncestorBST().lowestCommonAncestor(treeNode, treeNode.left, treeNode.left.right));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean isRootPivot = root.val == p.val || root.val == q.val;
        TreeNode answer1 = null, answer2 = null;
        if (isRootPivot && (dfs(root.left, p, q) || dfs(root.right, p, q))) {
            return root;
        }
        if (dfs(root.left, p, q) && dfs(root.right, p, q)) {
            return root;
        }
        if (root.left != null) {
            answer1 = lowestCommonAncestor(root.left, p, q);
        }
        if (root.right != null) {
            answer2 = lowestCommonAncestor(root.right, p, q);
        }
        if (answer1 != null) {
            return answer1;
        } else {
            return answer2;
        }
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean isRootPivot = root.val == p.val || root.val == q.val;
        if (isRootPivot) {
            return true;
        } else {
            boolean isLeftHasPivot = false;
            boolean isRightHasPivot = false;
            if (root.left != null) {
                isLeftHasPivot = dfs(root.left, p, q);
            }
            if (root.right != null) {
                isRightHasPivot = dfs(root.right, p, q);
            }
            return isLeftHasPivot || isRightHasPivot;
        }
    }
}
