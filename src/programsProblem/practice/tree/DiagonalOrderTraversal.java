package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.*;

public class DiagonalOrderTraversal {
    public void driverMethod() {
        TreeNode root = new TreeBuilder().buildTree("1 2 3 4 5 N 6 N N 7 8 9 N N N N 10");
        System.out.println(diagonalOrderTraversal1(root));
    }

    //Recursive
    private List<Integer> diagonalOrderTraversal1(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int hd = 0;
        helperMethod(root, map, hd);

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.addAll(entry.getValue());
        }

        return res;
    }

    private void helperMethod(TreeNode root, Map<Integer, List<Integer>> map, int hd) {
        if(root == null) return;

        List<Integer> lst = map.get(hd);
        if(lst == null) {
            lst = new ArrayList<>();
            lst.add(root.val);
        } else {
            lst.add(root.val);
        }
        map.put(hd, lst);

        helperMethod(root.left, map, hd + 1);
        helperMethod(root.left, map, hd);
    }

    //Iterative: Fails, not coming to correct order.
    private List<Integer> diagonalOrderTraversal(TreeNode root) {
        Map<Integer, List<Integer>> resStore = new TreeMap<>();
        Stack<Pair<Integer, TreeNode>> que = new Stack<>();

        que.add(new Pair<>(1, root));
        while (!que.isEmpty()) {
            Pair<Integer, TreeNode> pair = que.pop();
            int hd = pair.getKey();
            TreeNode curr = pair.getValue();

            if(!resStore.containsKey(hd)) {
                List<Integer> lst = new ArrayList<>();
                lst.add(curr.val);
                resStore.put(hd, lst);
            } else {
                resStore.get(hd).add(curr.val);
            }

            if(curr.right != null) que.push(new Pair<>(hd, curr.right));
            if(curr.left != null) que.push(new Pair<>(hd + 1, curr.left));
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : resStore.entrySet()) {
            res.addAll(entry.getValue());
        }
        return res;
    }

    static class Pair<T, K> {
        T key;
        K value;

        public Pair(T key, K value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return this.key;
        }

        public K getValue() {
            return this.value;
        }
    }
}
