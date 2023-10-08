package programsProblem.practice.tree;

import javafx.util.Pair;
import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
    public void driverMethod() {
        TreeNode root = new TreeBuilder().buildTree("1 2 3 4 5 6 7 9");

        System.out.println(verticalOrder(root));
    }

    //Similar to Level order traversal
    private ArrayList<Integer> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();  //Taken TreeMap because we need to print map in sorted order with respect to keys.
        Queue<Pair<Integer, TreeNode>> que = new LinkedList<>();

        que.add(new Pair<>(0, root));
        while (!que.isEmpty()) {
            Pair<Integer, TreeNode> pair = que.poll();
            TreeNode curr = pair.getValue();
            int heightDistance = pair.getKey();

            if(map.containsKey(heightDistance)) {
                map.get(heightDistance).add(curr.val);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(curr.val);
                map.put(heightDistance, lst);
            }

            if(curr.left != null) que.add(new Pair<>(heightDistance - 1, curr.left));
            if(curr.right != null) que.add((new Pair<>(heightDistance + 1, curr.right)));
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.addAll(entry.getValue());
        }
        return res;
    }
}
