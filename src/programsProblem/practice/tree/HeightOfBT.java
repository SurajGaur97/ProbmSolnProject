package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//Remark: Level or height or depth of a binary tree are same things.
public class HeightOfBT {

    public void driveMethod() {
//        TreeNode root = TreeBuilder.buildTree("2 N 3 N 4 N 5 N 6");
        TreeNode root = TreeBuilder.buildTree("3 9 20 N N 15 7");
        System.out.println(maxDepth(root));
        System.out.println(minDepth1(root));
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int lsize = this.maxDepth(root.left);
        int rsize = this.maxDepth(root.right);

        return Math.max(lsize, rsize) + 1;      //or Math.max(lsize + 1, rsize + 1);  <-(mine thought)
    }

    public int minDepth1(TreeNode root) {
        if(root == null)
            return 0;

        int lsize = this.minDepth1(root.left);
        int rsize = this.minDepth1(root.right);

        if(root.left == null && root.right == null){
            return lsize + rsize + 1;
        }

        return Math.max(lsize, rsize) + 1;      //or Math.max(lsize + 1, rsize + 1);  <-(mine thought)
    }

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i < size;i++){
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            count++;
        }
        return count;
    }
}
