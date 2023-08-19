package programsProblem.practice.tree;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int lsize = this.maxDepth(root.left);
        int rsize = this.maxDepth(root.right);
        return Math.max(lsize, rsize) + 1;
    }

    private int getSizeOfTree (TreeNode node) {
        if (node == null)
            return 0;
        int lsize = this.getSizeOfTree(node.left);
        int rsize = this.getSizeOfTree(node.right);
        return lsize + rsize + 1;
    }
}
