package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//Remark: Level or height or depth of a binary tree are same things.
public class LevelOfBinaryTree {
    TreeBuilder treeBuilder = new TreeBuilder();

    public void driverMethod() {
        TreeNode root = treeBuilder.buildTree("1 2 3 4 5 6 7 9");

        System.out.println(getLevel(root));
    }

    private int getLevel(TreeNode root) {
        if(root == null) return 0;

        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }
        return level;
    }
}
