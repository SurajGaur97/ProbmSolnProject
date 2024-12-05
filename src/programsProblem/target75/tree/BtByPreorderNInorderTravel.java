package programsProblem.target75.tree;

import programsProblem.practice.tree.utils.TreeNode;
import programsProblem.utils.DriverClass;

public class BtByPreorderNInorderTravel implements DriverClass<TreeNode> {
    int ndx = 0;

    @Override
    public void driverMethod(){
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        printElement(buildTree(preorder, inorder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder){
        int len = inorder.length;
        return getTree(preorder, inorder, 0, len - 1);
    }

    private TreeNode getTree(int[] preorder, int[] inorder, int srt, int end){
        if(srt > end) return null;

        TreeNode root = new TreeNode(preorder[ndx++]);
        int i = srt;
        for(;i <= end;i++)
            if(inorder[i] == root.val)
                break;

        root.left = getTree(preorder, inorder, srt, i - 1);
        root.right = getTree(preorder, inorder, i + 1, end);

        return root;
    }
}
