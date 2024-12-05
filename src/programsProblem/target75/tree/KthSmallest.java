package programsProblem.target75.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;
import programsProblem.utils.DriverClass;

public class KthSmallest implements DriverClass<Integer> {
    int i = 0;
    int res = 0;

    @Override
    public void driverMethod(){
        TreeNode root = TreeBuilder.buildTree("5,3,6,2,4,null,null,1");
        printElement(kthSmallest(root, 3));
    }

    public int kthSmallest(TreeNode root, int k){
        i = k;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root){
        if(root.left != null)
            inorder(root.left);
        i--;
        if(i == 0){
            res = root.val;
            return;
        }
        if(root.right != null)
            inorder(root.right);
    }
}
