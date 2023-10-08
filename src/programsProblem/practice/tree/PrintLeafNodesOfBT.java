package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

public class PrintLeafNodesOfBT {
    public void driverMethod() {
        TreeNode root = new TreeBuilder().buildTree("1 2 3 4 5 6 7 8 9 N N 15 N 10 11 17 12 N 14 N N N N N N N N 16 13");

        printNodes(root);
    }

    private void printNodes(TreeNode root) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            System.out.print(root.val + " ");
        }

        printNodes(root.left);
        printNodes(root.right);
    }
}
