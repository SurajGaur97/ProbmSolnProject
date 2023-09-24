package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

public class BalancedBT {
    TreeBuilder treeBuilder = new TreeBuilder();

    public void driverMethod() {
//        TreeNode root = treeBuilder.buildTree("1 2 2 3 N N 3 4 N N 4");
        TreeNode root = treeBuilder.buildTree(("3 9 20 N N 15 7"));

        System.out.println(!isBalanced1(root));
    }

    //See 'Apna College' YouTube video to get better understanding of this algo. Link: https://www.youtube.com/watch?v=bh4eb_6SwRA
    private boolean isBalanced1(TreeNode root) {
        if(root == null) return false;
        if(isBalanced1(root.left)) return true;
        if(isBalanced1(root.right)) return true;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        return Math.abs(lh - rh) > 1;
    }

    //Passed. (Mine Thought) 100% efficient and passes all cases on  Leetcode
    private boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int leftSubTreeHeight = getHeight(root.left);
        int rightSubTreeHeight = getHeight(root.right);

        int res = Math.abs(leftSubTreeHeight - rightSubTreeHeight);

        return res <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //Failed (Mine Thought) but didn't work.
    private boolean isBalanced(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;

        int leftSubTreeHeight = getHeight(root1);
        int rightSubTreeHeight = getHeight(root2);

        int res = Math.abs(leftSubTreeHeight - rightSubTreeHeight);

        return res <= 1 && isBalanced(root1.left, root2.right);
    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
