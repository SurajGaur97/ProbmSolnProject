package programsProblem.target75.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;
import programsProblem.utils.DriverClass;

public class InvertBinaryTree implements DriverClass<TreeNode> {

    @Override
    public void driverMethod(){
        TreeNode root = TreeBuilder.buildTree("4,2,7,1,3,6,9");
        printElement(invertTree(root));
    }

    //Solution using post-order traversal
    public TreeNode invertTree(TreeNode root){
        // Base case: end recursive call if current node is null
        if(root == null){
            return null;
        }

        // We will do a post-order traversal of the binary tree.
        if(root.left != null){
            invertTree(root.left);
        }
        if(root.right != null){
            invertTree(root.right);
        }

        // Let's swap the left and right nodes at current level.
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
