package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBT {
    public void driverMethod() {
        TreeNode root = new TreeBuilder().buildTree("1 2 3 4 5 6 7 9");

        System.out.println(levelOrderTraversalIterative(root));
    }

    //Iterative Approach
    //Algo:
    //step.1: assign root to a queue data structure.
    //step.2: repeat steps 3 to 9 until queue gets empty.
    //step.3: create a new list of integer: lst, for pushing to level element values.
    //step.4: repeat the steps 5 to 9 as the size of the queue.
    //step.5: poll (pop and remove the first element) from queue in a temporary Node: curr.
    //step.6: add the value of node to the list of integer lst.
    //step.7: add the left node of curr to the queue if the curr.left is not null.
    //step.8: add the right node of curr to the queue if the curr.right is not null.
    //step.9: add the list of integer lst to list of list: res.
    //step.10: return the list of list: res, created.
    private List<List<Integer>> levelOrderTraversalIterative(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> lst = new ArrayList<>();
            int size = queue.size();    //Need to take separately because it changes every time when queue changes
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                lst.add(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            res.add(lst);
        }
        return res;
    }

    //Recursive Approach need to method: levelOrder() and getNodesAtLevel()
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        int level = getLevelOfBT(root);
        for (int i = 1; i <= level; i++) {
            List<Integer> res = new ArrayList<>(getNodesAtLevel(root, i, new ArrayList<>()));
            lists.add(res);
        }
        return lists;
    }

    private List<Integer> getNodesAtLevel(TreeNode root, int level, List<Integer> res) {
        if(root == null) return res;

        if(level == 1) res.add(root.val);

        if(level > 1) {
            getNodesAtLevel(root.left, level - 1, res);
            getNodesAtLevel(root.right, level - 1, res);
        }
        return res;
    }

    private int getLevelOfBT(TreeNode root) {
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
