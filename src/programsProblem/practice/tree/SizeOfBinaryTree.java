package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeNode;

public class SizeOfBinaryTree {
    public void driverMethod() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        int size = getSize(root);
        System.out.println(size);
    }

    //counting all nodes present in a tree.
    private int getSize(TreeNode root) {
        if (root == null) return 0;

        int leftCount = getSize(root.left);
        int rightCount = getSize(root.right);

        return leftCount + rightCount + 1;
    }
}
