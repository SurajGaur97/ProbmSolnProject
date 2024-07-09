package programsProblem.practice.tree.binaryTree;

import programsProblem.practice.common.DriverClass;
import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

public class LowestCommonAncestor236 implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        TreeNode root = TreeBuilder.buildTree("3,5,1,6,2,0,8,null,null,7,4");
        TreeNode p = TreeBuilder.buildTree("7");
        TreeNode q = TreeBuilder.buildTree("4");

        printElement(lowestCommonAncestor(root, p, q).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
}
