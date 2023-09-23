package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

public class MaxMinElementInBT {
    TreeBuilder treeBuilder = new TreeBuilder();

    public void driverMethod() {
        TreeNode root = treeBuilder.buildTree("3 1 10 N 2 5 N N N 4 7 N N 6 8 N N N 9");

        System.out.println(getMinElement(root));
        System.out.println(getMaxElement(root));
    }

    private int getMinElement(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        int leftNode = getMinElement(root.left);
        int rightNode = getMinElement(root.right);

        return Math.min(root.val, Math.min(leftNode, rightNode));
    }

    private int getMaxElement(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;

        int leftNode = getMaxElement(root.left);
        int rightNode = getMaxElement(root.right);

        return Math.max(root.val, Math.max(leftNode, rightNode));
    }
}
