package programsProblem.practice.tree.binarySearchTree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;
import programsProblem.utils.DriverClass;

public class DeleteNode implements DriverClass<TreeNode> {
    @Override
    public void driverMethod(){
//        TreeNode root = TreeBuilder.buildTree("5,3,6,2,4,null,7");
//        int key = 3;
//        TreeNode root = TreeBuilder.buildTree("0");
//        int key = 0;
//        TreeNode root = TreeBuilder.buildTree("5,3,6,2,4,null,7");
//        int key = 5;
//        TreeNode root = TreeBuilder.buildTree("5,3,6,2,4,null,7");
//        int key = 7;
//        TreeNode root = TreeBuilder.buildTree("2,1");
//        int key = 2;
        TreeNode root = TreeBuilder.buildTree("10,5,50,null,null,20,80,null,null,70,100,60,null,null,null,null,65");    //10 5 60 null null 20 80 null null 70 100 65
        int key = 50;

        printElement(deleteNode(root, key));
    }

    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return root;

        if(root.val < key)
            root.right = deleteNode(root.right, key);
        else if(root.val > key)
            root.left = deleteNode(root.left, key);

        if(root.val == key){
            if(root.left == null && root.right == null)
                root = null;

            else if(root.left == null && root.right != null)
                root = root.right;

            else if(root.left != null && root.right == null)
                root = root.left;

            else if(root.left != null && root.right != null){
                TreeNode rightLowest = getRightLowestNode(root.right);
                //root.val = rightLowest.val;
                root.val = getMinRightVal(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }

    private int getMinRightVal(TreeNode root){
        int minVal = root.val;
        if(root.left != null){
            minVal = getMinRightVal(root.left);
        }
        return minVal;
    }

    private TreeNode getRightLowestNode(TreeNode root){
        if(root == null) return root;

        if(root.left == null && root.right == null)
            return root;

        TreeNode rightMostLowest = getRightLowestNode(root.left);

        return rightMostLowest == null ? root : rightMostLowest;
    }

}
