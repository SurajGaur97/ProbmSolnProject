package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

public class Check2BTIdentical {
    TreeBuilder treeBuilder = new TreeBuilder();

    public void driverMethod() {
        TreeNode root1 = treeBuilder.buildTree("1 2 3");
        TreeNode root2 = treeBuilder.buildTree("1 2 3");

        System.out.println(isIdentical(root1, root2));
    }

    private boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        if(!isIdentical(root1.left, root2.left)) return false;
        if(!isIdentical(root1.right, root2.right)) return false;

        return root1.val == root2.val;
    }
}
