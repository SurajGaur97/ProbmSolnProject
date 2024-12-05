package programsProblem.target75.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;
import programsProblem.utils.DriverClass;

public class LcaOfBst implements DriverClass<TreeNode> {
    @Override
    public void driverMethod(){
        TreeNode root = TreeBuilder.buildTree("6,2,8,0,4,7,9,null,null,3,5");
        TreeNode p = TreeBuilder.buildTree("");
        TreeNode q = TreeBuilder.buildTree("");
        lowestCommonAncestor(root, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        return root;
    }
}
