package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

public class SymmetricBT {
    TreeBuilder build = new TreeBuilder();

    public void driverMethod() {
        TreeNode root = build.buildTree("5 1 1 2 3 4 2");
        System.out.println(isSymmetric(root));
    }

    private boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return checkSymmetry1(root.left, root.right);
    }

    // For this solution see BalanceBT algo for better understanding.
    private boolean checkSymmetry1(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;

        else if(root1 == null || root2 == null) return false;

        else {
            boolean leftRightCheck = checkSymmetry1(root1.left, root2.right);   //Matching left with right
            boolean rightLeftCheck = checkSymmetry1(root1.right, root2.left);    //Matching right with left

            if(!leftRightCheck) return false;
            if(!rightLeftCheck) return false;

            return root1.val == root2.val;
        }
    }

    private boolean checkSymmetry(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;

        else if(root1 == null || root2 == null) return false;

        else {
            boolean leftRightCheck = checkSymmetry(root1.left, root2.right);   //Matching left with right
            boolean rightLeftCheck = checkSymmetry(root1.right, root2.left);    //Matching right with left

            return root1.val == root2.val && leftRightCheck && rightLeftCheck;
        }
    }
}
