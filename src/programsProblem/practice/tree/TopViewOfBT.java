package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.Pair;
import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.*;

public class TopViewOfBT {
    public void driverMethod() {
        TreeNode root = new TreeBuilder().buildTree("1 2 3 4 5 6 7 9");
        System.out.println(topView(root));
    }

    //Similar to vertical order traversal
    private List<Integer> topView(TreeNode root) {
        //only changed values of map to take integer not the list of Integer in value of map.
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<Integer, TreeNode>> que = new LinkedList<>();

        que.add(new Pair<>(0, root));

        while (!que.isEmpty()) {
            Pair<Integer, TreeNode> pair = que.poll();
            TreeNode curr = pair.getValue();
            int heightDistance = pair.getKey();

            if(!map.containsKey(heightDistance)) {
                map.put(heightDistance, curr.val);
            }

            if(curr.left != null) que.add(new Pair<>(heightDistance - 1, curr.left));
            if(curr.right != null) que.add((new Pair<>(heightDistance + 1, curr.right)));
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
