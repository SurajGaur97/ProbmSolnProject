package programsProblem.practice.tree.binaryTree;

import programsProblem.practice.common.DriverClass;
import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees872 implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        TreeNode tree1 = TreeBuilder.buildTree("3,5,1,6,2,9,8,N,N,7,4");
        TreeNode tree2 = TreeBuilder.buildTree("3,5,1,6,7,4,2,N,N,N,N,N,N,9,8");

        System.out.println(leafSimilar(tree1, tree2));
    }

    private boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();

        mapToList(root1, lst1);
        mapToList(root2, lst2);

        return lst1.equals(lst2);
    }

    private void mapToList(TreeNode root, List<Integer> lst) {
        if(root == null) return;

        if(root.left == null && root.right == null){
            lst.add(root.val);
        }

        mapToList(root.left, lst);
        mapToList(root.right, lst);
    }
}
