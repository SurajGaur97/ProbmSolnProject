package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalBT {
    TreeBuilder treeBuilder = new TreeBuilder();
    //Recursive Approach
    private final List<Integer> res = new ArrayList<>();

    public void driverMethod() {
        TreeNode root = treeBuilder.buildTree("1 2 3 4 5 6");

        for (Integer a : inOrderTraversal1(root))
            System.out.print(a + " ");
    }

    //Iterative Approach
    private List<Integer> inOrderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    private List<Integer> inOrderTraversal(TreeNode root) {
        if(root == null) return res;

        inOrderTraversal(root.left);
        res.add(root.val);
        inOrderTraversal(root.right);

        return res;
    }
}
