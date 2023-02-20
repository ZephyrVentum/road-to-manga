package miscellanea.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
//        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(new TreeNode(1, new TreeNode(), new TreeNode()), new TreeNode(2));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            final TreeNode currentNode = queue.poll();
            if (result.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                level.add(currentNode.val);
                result.add(level);
            }
            if (currentNode.left != null && currentNode.right != null) {
                List<Integer> level = new ArrayList<>();
                level.add(currentNode.left.val);
                level.add(currentNode.right.val);
                result.add(level);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            } else if (currentNode.left != null){
                queue.add(currentNode.left);
                List<Integer> level = new ArrayList<>();
                level.add(currentNode.left.val);
                result.add(level);
            } else if (currentNode.right != null){
                queue.add(currentNode.right);
                List<Integer> level = new ArrayList<>();
                level.add(currentNode.right.val);
                result.add(level);
            }
        }
        return result;
    }
}

//else if (queue.size() == 1) {
//        List<Integer> level = new ArrayList<>();
//        level.add(currentNode.val);
//        result.add(level);
//        }
