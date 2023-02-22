package utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode arrayToTree(Integer array[]) {
        return arrayToTree(array, 0);
    }

    public static TreeNode arrayToTree(Integer array[], int index) {
        if (index >= array.length)
            return null;
        if (array[index] == null)
            return null;
        return new TreeNode(array[index], arrayToTree(array, index * 2 + 1), arrayToTree(array, index * 2 + 2));
    }
}
