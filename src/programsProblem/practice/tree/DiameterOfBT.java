package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

public class DiameterOfBT {
    TreeBuilder treeBuilder = new TreeBuilder();

    public void driverMethod() {
        TreeNode root = treeBuilder.buildTree("1 2 3 4 5 N N");   //pre order assignment
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

        int diameter = diameterOfBinaryTree(root);
        System.out.println(diameter);
    }

    private int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1]; // Store the diameter in an array for reference
        calculateDiameter(root, diameter);
        return diameter[0];
    }

    private int calculateDiameter(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = calculateDiameter(node.left, diameter);
        int rightHeight = calculateDiameter(node.right, diameter);

        // Update the diameter result by taking the maximum diameter that passes through the current node
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        // Return the maximum depth of the current node by adding 1 to the maximum depth of its deepest subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
