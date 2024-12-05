package programsProblem.target75.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;
import programsProblem.utils.DriverClass;

public class SubtreeOfAnotherTree implements DriverClass<Boolean> {
    @Override
    public void driverMethod(){
        TreeNode root = TreeBuilder.buildTree("3,4,5,1,2");
        TreeNode subRoot = TreeBuilder.buildTree("4,1,2");

        printElement(isSubtree1(root, subRoot));
    }

    public boolean isSubtree1(TreeNode root, TreeNode subRoot){
        StringBuilder rStr = new StringBuilder();
        StringBuilder sStr = new StringBuilder();

        traverse(root, rStr.append(","));
        traverse(subRoot, sStr.append(","));

        return rStr.indexOf(String.valueOf(sStr)) != -1;
    }

    private void traverse(TreeNode root, StringBuilder arr){
        if(root == null){
            arr.append("n,");
            return;
        }

        arr.append(root.val).append(",");

        traverse(root.left, arr);
        traverse(root.right, arr);
    }

    //not working
    private boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(root == null || subRoot == null)
            return true;

        if(root.val == subRoot.val)
            return isSame(root, subRoot);

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null)
            return true;

        else if(root == null || subRoot == null || root.val != subRoot.val)
            return false;

        if(!isSame(root.left, subRoot.left)) return false;
        return isSame(root.right, subRoot.right);
    }
}
