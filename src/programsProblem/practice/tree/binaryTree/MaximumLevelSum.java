package programsProblem.practice.tree.binaryTree;

import programsProblem.practice.common.DriverClass;
import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumLevelSum implements DriverClass<Integer> {
    int[] sums = new int[1000];
    int treeLevel = 1;

    @Override
    public void driverMethod() {
//        TreeNode root = TreeBuilder.buildTree("1,7,0,7,-8,null,null");  //res = 2
        TreeNode root = TreeBuilder.buildTree("1,1,0,7,-8,-7,9");     //res = 1
//        TreeNode root = TreeBuilder.buildTree("1,2,3");     //res = 2

//        printElement(maxLevelSum(root));
//        printElement(maxLevelSum1(root));

        printElement(maxLevelSum2(root));

//        Map<Integer, Integer> map = new HashMap<>();
//        sumDfsTestPurposeOnly(root, 0, map);
    }

    private int maxLevelSum2(TreeNode root) {
//        Map<Integer, Integer> map = new HashMap<>();
        int[] sums = new int[10000];
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);
        int level = 1;

        while (!que.isEmpty()){
            int size = que.size();
            for (int i = 0;i < size;i++){
                TreeNode node = que.poll();

                sums[level] += node.val;
//                map.put(level, map.getOrDefault(level, 0) + node.val);

                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            level++;
        }

//        return map.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(0);

        int reqLevel = 0, maxVal = Integer.MIN_VALUE;

        for (int i = 1;i < level;i++){
            if(maxVal < sums[i]){
                maxVal = sums[i];
                reqLevel = i;
            }
        }

        return reqLevel;
    }

    public int maxLevelSum1(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int reqLevel = 0;

        helperMethod1(root, 1);

        for (int i = 1;i <= treeLevel;i++){
            if(maxSum < sums[i]){
                maxSum = sums[i];
                reqLevel = i;
            }
        }
        return reqLevel;
    }

    private void helperMethod1(TreeNode root, int level) {
        if(root == null) return;

        sums[level] += root.val;

        helperMethod1(root.left, level + 1);
        helperMethod1(root.right, level + 1);

        if(treeLevel < level)
            treeLevel = level;
    }

    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helperMethod(root, map, 1);

        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);
    }

    private void helperMethod(TreeNode root, Map<Integer, Integer> map, int level) {
        if(root == null) return;

        map.put(level, map.getOrDefault(level, 0) + root.val);

        helperMethod(root.left, map, level + 1);
        helperMethod(root.right, map, level + 1);
    }

    private void sumDfsTestPurposeOnly(TreeNode root, int width, Map<Integer, Integer> map) {
        if(root == null) return;

        map.put(width, map.getOrDefault(width, 0) + root.val);

        sumDfsTestPurposeOnly(root.left, width - 1, map);
        sumDfsTestPurposeOnly(root.right, width + 1, map);
    }

}
