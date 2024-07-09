package programsProblem.practice.tree.binaryTree;

import programsProblem.practice.common.DriverClass;
import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 implements DriverClass<Integer> {
    int count = 0;

    @Override
    public void driverMethod() {
        TreeNode root = TreeBuilder.buildTree("10,5,-3,3,2,null,11,3,-2,null,1");
        int target = 8;

        printElement(pathSum(root, target));
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();

        getPathSum(root, targetSum, 0, map);
        return count;
    }

    private void getPathSum(TreeNode root, int targetSum, long sum, Map<Long, Integer> map) {
        if(root == null) return;

        sum += root.val;

        if(map.containsKey(sum - targetSum))
            count += map.get(sum - targetSum);

        if(targetSum == sum)
            count++;

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        getPathSum(root.left, targetSum, sum, map);
        getPathSum(root.right, targetSum, sum, map);

        map.put(sum, map.get(sum) - 1);
    }
}
