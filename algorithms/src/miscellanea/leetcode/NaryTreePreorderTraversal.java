package miscellanea.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NaryTreePreorderTraversal());
    }

    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> answer = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            if (root != null) {
                stack.add(root);
            }
            while (!stack.isEmpty()) {
                Node topNode = stack.pop();
                answer.add(topNode.val);
                for (int i = topNode.children.size() - 1; i > 0; i--) {
                    stack.push(topNode.children.get(i));
                }
            }
            return answer;
        }
    }
}
