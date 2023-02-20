package miscellanea.leetcode;

import utils.Pair;

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
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int lastNodeLevel = 0;
        if (root != null) {
            queue.add(new Pair<TreeNode, Integer>(root, lastNodeLevel));
        }
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            final Pair<TreeNode, Integer> currentPair = queue.poll();
            final TreeNode currentNode = currentPair.first;
            final int currentLevel = currentPair.second;
            if (lastNodeLevel < currentLevel) {
                lastNodeLevel = currentLevel;
                result.add(level);
                level = new ArrayList<>();
            }
            level.add(currentNode.val);
            if (currentNode.left != null) {
                queue.add(new Pair<TreeNode, Integer>(currentNode.left, currentLevel + 1));
            }
            if (currentNode.right != null) {
                queue.add(new Pair<TreeNode, Integer>(currentNode.right, currentLevel + 1));
            }
        }
        result.add(level);
        return result;
    }
}
