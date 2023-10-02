package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBT {
    TreeBuilder treeBuilder = new TreeBuilder();

    public void driverMethod() {
        TreeNode root = treeBuilder.buildTree("1 2 3 4 5 6 7 9");

        leftView(root);
    }

    private void leftView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = root;

        while (!queue.isEmpty()) {
            if(curr != null) {
                queue.add(curr);
                curr = curr.left;
            }
            curr = queue.poll();
            System.out.print(curr.val + " ");
            if(curr != null) curr = curr.right;
            else return;
        }
    }
}
