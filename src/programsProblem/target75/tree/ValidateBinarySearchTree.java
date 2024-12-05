package programsProblem.target75.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;
import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree implements DriverClass<Boolean> {
    boolean isValid = false;
    long prev = Long.MIN_VALUE;

    @Override
    public void driverMethod(){
        TreeNode root = TreeBuilder.buildTree("5,4,6,null,null,3,7");
        printElement(isValidBST1(root));
    }

    public boolean isValidBST1(TreeNode root){
        inorder(root);
        return isValid;
    }

    void inorder(TreeNode root){
        if(root.left != null) inorder(root.left); // Traverse the left subtree

        int val = root.val;
        // Check if current node value is greater than the previous node value
        if(prev >= val){
            isValid = false;
            return;
        }
        prev = val; // Update previous node value

        if(root.right != null) inorder(root.right); // Traverse the right subtree
    }

    public boolean isValidBST(TreeNode root){
        List<Integer> res = new ArrayList<>();

        solve(root, res);

        for(int i = 0;i < res.size() - 1;i++)
            if(res.get(i) >= res.get(i + 1))
                return false;

        return true;
    }

    private void solve(TreeNode root, List<Integer> res){
        if(root == null) return;

        //inorder traversal
        solve(root.left, res);
        res.add(root.val);
        solve(root.right, res);
    }
}
