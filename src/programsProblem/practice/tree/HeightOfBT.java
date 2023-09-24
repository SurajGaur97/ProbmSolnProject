package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeNode;

public class HeightOfBT {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int lsize = this.maxDepth(root.left);
        int rsize = this.maxDepth(root.right);

        return Math.max(lsize, rsize) + 1;      //or Math.max(lsize + 1, rsize + 1);  <-(mine thought)
    }
}
