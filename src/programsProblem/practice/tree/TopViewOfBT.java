package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.Pair;
import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;
import programsProblem.utils.DriverClass;

import java.util.*;

public class TopViewOfBT implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        TreeNode root = TreeBuilder.buildTree("1,2,3,4,5,6,7,9");   //[9, 4, 2, 1, 3, 7]
//        printElement(topView(root));
        printElement(topViewRecursive(root));
    }

    private List<Integer> topViewRecursive(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        helperMethod(root, 0, map);

        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }

    private void helperMethod(TreeNode root, int heightDistance, Map<Integer, Integer> map) {
        if(root == null) return;

        if(!map.containsKey(heightDistance))
            map.put(heightDistance, root.val);

        helperMethod(root.left, heightDistance - 1, map);
        helperMethod(root.right, heightDistance + 1, map);
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
