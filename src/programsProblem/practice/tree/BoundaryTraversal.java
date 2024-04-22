package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.Pair;
import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.*;

public class BoundaryTraversal {
    public void driverMethod() {
        TreeNode root = new TreeBuilder().buildTree("1 2 3 4 5 6 7 8 9 N N 10 N 11 12 13 14 N 15 N N N N N N N N 16 17");
        /*
                                1
                             /     \
                            2       3
                           / \     / \
                          4   5   6   7
                         / \     /   / \
                        8   9   10  11 12
                       / \   \
                      13 14  15
                         / \
                        16 17
         */
        System.out.println(boundaryTraversal(root));
    }

    //--------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Correct Approach: Just print root node -> left boundary nodes -> leaf nodes -> right boundary nodes.
    private List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        res.add(root.val);
        leftBoundary(root.left, res);
        leafNodes(root, res);
        rightBoundary(root.right, res);

        return res;
    }

    //Getting left boundary nodes
    private void leftBoundary(TreeNode root, List<Integer> res) {
        if(root == null) return;

        if(root.left != null || root.right != null) {
            res.add(root.val);
        }

        if(root.left != null) leftBoundary(root.left, res);
        else if(root.right != null) leftBoundary(root.right, res);
    }

    //Getting right boundary nodes
    private void rightBoundary(TreeNode root, List<Integer> res) {
        if(root == null) return;

        if(root.right != null) rightBoundary(root.right, res);
        else if(root.left != null) rightBoundary(root.left, res);

        if(root.left != null || root.right != null) {
            res.add(root.val);
        }
    }

    //Getting leaf nodes
    private void leafNodes(TreeNode root, List<Integer> res) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            res.add(root.val);
        }

        if(root.left != null) leafNodes(root.left, res);
        if(root.right != null) leafNodes(root.right, res);
    }
    //--------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //My approach: Printing Top view and bottom view of Tree. But it not the correct approach.
    private List<Integer> getBoundaryNodes(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();    //Height and Top and Bottom values list Map.
        Queue<Pair<Integer, TreeNode>> que = new LinkedList<>();

        que.add(new Pair<>(0, root));

        while (!que.isEmpty()) {
            Pair<Integer, TreeNode> pair = que.poll();
            int hd = pair.getKey();
            TreeNode curr = pair.getValue();

            //Top View
            if(!map.containsKey(hd)) {
                List<Integer> lst = new ArrayList<>(2);
                lst.add(curr.val);
                map.put(hd, lst);
            }
            //Bottom View
            else {
                map.get(hd).add(1, curr.val);
            }

            if(curr.left != null) que.add(new Pair<>(hd - 1, curr.left));
            if(curr.right != null) que.add(new Pair<>(hd + 1, curr.right));
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getValue().get(0));
            if(entry.getValue().size() >= 2) res.add(entry.getValue().get(1));
        }

        return res;
    }
}
