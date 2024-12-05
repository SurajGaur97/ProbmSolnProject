package programsProblem.practice.tree.binaryTree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;
import programsProblem.utils.DriverClass;

public class CountGoodNodesInBinaryTree implements DriverClass<Integer> {

    @Override
    public void driverMethod() {
        TreeNode root = TreeBuilder.buildTree("3,1,4,3,N,1,5");
        printElement(goodNodes(root));
    }

    private int goodNodes(TreeNode root) {
        return getGoodNode(root, 0, root.val);
    }

    private int getGoodNode(TreeNode root, int count, int rootVal) {
        if(root == null) return 0;

        if(root.val >= rootVal)
            count++;

        count = Math.max(getGoodNode(root.left, count, rootVal), getGoodNode(root.right, count, rootVal));

        return count;
    }
}
