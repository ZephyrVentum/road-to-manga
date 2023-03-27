package miscellanea.leetcode;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Integer[] tree = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode treeNode = TreeNode.newTree(tree);
        System.out.println(new InvertBinaryTree().invertTree(treeNode));
    }

    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
