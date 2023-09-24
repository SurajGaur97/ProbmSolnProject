package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

public class Check2BTIsomorphic {
    TreeBuilder treeBuilder = new TreeBuilder();

    public void driverMethod() {
//        TreeNode root1 = treeBuilder.buildTree("1 2 3 4");
//        TreeNode root2 = treeBuilder.buildTree("1 3 2 4");

//        TreeNode root1 = treeBuilder.buildTree("1 2 3 4");
//        TreeNode root2 = treeBuilder.buildTree("1 3 2 N N N 4");

        TreeNode root1 = treeBuilder.buildTree("1 2 3 4 5 6 N N N 7 8");
        TreeNode root2 = treeBuilder.buildTree("1 3 2 N 6 4 5 N N N N 8 7");

        System.out.println(checkIsomorphic(root1, root2));
    }

    private boolean checkIsomorphic(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        boolean lr1 = checkIsomorphic(root1.left, root2.left);  //Checking Mirror to each other of both root's left-left
        boolean lr2 = checkIsomorphic(root1.left, root2.right);  //Checking Symmetry to each other of both root's left-right

        boolean rr1 = checkIsomorphic(root1.right, root2.right);  //Checking Mirror to each other of both root's right-right
        boolean rr2 = checkIsomorphic(root1.right, root2.left);  //Checking Symmetry to each other of both root's right-left

        boolean left = lr1 || lr2;  //Checking (mirror) or (symmetry) of 2 sides roots
        boolean right = rr1 || rr2; //Checking (mirror) or (symmetry) of 2 sides roots

        if(!left) return false;  //if any left not matched return false
        if(!right) return false;  //if any right not matched return false

        return root1.val == root2.val;  //Checking value matched then returning true;
    }
}
