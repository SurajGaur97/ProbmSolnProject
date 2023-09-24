package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalBT {
    TreeBuilder treeBuilder = new TreeBuilder();
    //Recursive Approach
    List<Integer> res = new ArrayList<>();

    public void driverMethod() {
        TreeNode root = treeBuilder.buildTree("1 2 3 4 5 6");

        for (Integer a : preOrderTraversal1(root))
            System.out.print(a + " ");
    }

    //Iterative Approach
    private List<Integer> preOrderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            res.add(curr.val);

            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);
        }
        return res;
    }

    private List<Integer> preOrderTraversal(TreeNode root) {
        if(root == null) return res;

        res.add(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

        return res;
    }
}
