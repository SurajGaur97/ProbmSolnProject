package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

public class SymmetricTree {
    TreeBuilder build = new TreeBuilder();

    private static boolean isSymmetric(TreeNode root) {
        TreeNode res = helper(root);
        return res.val == -1;
    }

    private static TreeNode helper(TreeNode root) {
        if (root == null) return root;

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        if (left.val != right.val) return new TreeNode(-1);

        return root;
    }

    public void driverMethod() {
        TreeNode root = build.buildTree("");
    }
}
