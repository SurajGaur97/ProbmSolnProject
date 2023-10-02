package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalBT {
    TreeBuilder treeBuilder = new TreeBuilder();
    public void driverMethod() {
        TreeNode root = treeBuilder.buildTree("1 2 3 4 5 6");

        for (Integer a : inOrderTraversal1(root))
            System.out.print(a + " ");
    }

    //Recursive Approach
    private final List<Integer> res = new ArrayList<>();

    //Iterative Approach
    //Algo:
    //step.1: Create a stack data structure.
    //step.2: assign root to a temporary variable:curr of type TreeNode.
    //step.3: repeat step 4 to 7 until stack gets empty OR curr node is not null.
    //step.4: push curr node into the stack by traversing to left node of curr until curr node is not null. (here pushing the left node to the stack till last left depth).
    //step.5: pop the stack and assign it to the curr node.
    //step.6: print the value of curr node.
    //step.7: assign right node of curr to the curr node.
    //step.8: return the final result value.
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
