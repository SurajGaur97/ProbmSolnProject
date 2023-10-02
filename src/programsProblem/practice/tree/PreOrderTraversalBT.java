package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalBT {
    TreeBuilder treeBuilder = new TreeBuilder();
    //Recursive Approach

    public void driverMethod() {
        TreeNode root = treeBuilder.buildTree("1 2 3 4 5 6");

        for (Integer a : preOrderTraversal1(root))
            System.out.print(a + " ");
    }

    //Recursive Approach
    List<Integer> res = new ArrayList<>();

    //Iterative Approach
    //Algo:
    //step.1: assign root to a stack data structure.
    //step.2: repeat step 3 to 6 until stack gets empty.
    //step.3: pop the top element of the stack
    //step.4: print the value of pop element
    //step.5: add the right node to the stack
    //step.6: add the left node to the stack
    //step.7: return result array List.
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
