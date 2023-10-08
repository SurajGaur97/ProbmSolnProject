package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBT {
    public void driverMethod() {
        TreeNode root = new TreeBuilder().buildTree("1 2 3 4 5 6 7 9");
        System.out.println(rightViewBT(root));
    }

    //Recursive approach
    private List<Integer> rightViewBT(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightViewHelper(root, res, 0);
        return res;
    }

    private void rightViewHelper(TreeNode root, List<Integer> lst, int level) {
        if(root == null) return;

        if(lst.size() <= level) lst.add(level, root.val);
        else lst.set(level, root.val);

        rightViewHelper(root.left, lst, level + 1);
        rightViewHelper(root.right, lst, level + 1);
    }

    //Iterative approach
    private List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int level = que.size();
            for (int i = 0; i < level; i++) {
                TreeNode curr = que.poll();

                if(i == level - 1) res.add(curr.val);

                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
            }
        }
        return res;
    }
}
