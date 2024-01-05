package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagOrderTraversalOfBT {
    public void driverMethod() {
        TreeNode root = new TreeBuilder().buildTree("1 2 3 4 5 6 7");
        System.out.println(zigZagOrderTraversal1(root));
    }

    private List<Integer> zigZagOrderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        int level = 0;

        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            int lastNdx = res.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();

                if(level % 2 == 0) {
                    res.add(curr.val);
                } else {
                    res.add(lastNdx, curr.val);
                }

                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
            }
            level++;
        }
        return res;
    }

    private List<Integer> zigZagOrderTraversal(TreeNode root) {
        List<List<Integer>> temp = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();

                levelNodes.add(curr.val);

                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
            }
            temp.add(levelNodes);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            if(i % 2 == 0) {
                res.addAll(temp.get(i));
            } else {
                List<Integer> tmp = new ArrayList<>();
                for (int j = temp.get(i).size() - 1; j >= 0; j--) {
                    tmp.add(temp.get(i).get(j));
                }
                res.addAll(tmp);
            }
        }
        return res;
    }
}
