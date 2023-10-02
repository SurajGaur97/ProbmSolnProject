package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

//Remark: Level or height or depth of a binary tree are same things.
public class HeightOfBT {
    TreeBuilder treeBuilder = new TreeBuilder();

    public void driveMethod() {
        TreeNode root = treeBuilder.buildTree("1 2 3 4 5 6 7 9");
        System.out.println(maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int lsize = this.maxDepth(root.left);
        int rsize = this.maxDepth(root.right);

        return Math.max(lsize, rsize) + 1;      //or Math.max(lsize + 1, rsize + 1);  <-(mine thought)
    }
}
