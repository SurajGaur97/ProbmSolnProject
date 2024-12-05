package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewOfBT {

    public void driverMethod() {
//        TreeNode root = new TreeBuilder().buildTree("1 2 3 4 5 6 7 N 9 N N N N N N 8");
        TreeNode root = TreeBuilder.buildTree("4 5 2 N N 3 1 6 7");

        System.out.println(leftView(root));
    }

    private List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                if(i == 0) res.add(curr.val);   //printing the first node of the levels.

                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        return res;
    }
}
