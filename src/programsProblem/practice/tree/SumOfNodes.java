package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeNode;

public class SumOfNodes {
    public void driverMethod() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        int size = sumBT(root);
        System.out.println(size);
    }

    private int sumBT(TreeNode root) {
        if (root == null) return 0;

        int sumOfLeftBT = sumBT(root.left);
        int sumOfRightBT = sumBT(root.right);

        int totalNodeSum = sumOfLeftBT + sumOfRightBT + root.val;

        return totalNodeSum;
    }
}
