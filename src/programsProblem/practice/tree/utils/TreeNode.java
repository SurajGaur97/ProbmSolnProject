package programsProblem.practice.tree.utils;

public class TreeNode {
    public int val;

    public TreeNode right;

    public TreeNode left;

    public TreeNode(){
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
