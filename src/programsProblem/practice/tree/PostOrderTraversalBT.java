package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalBT {
    TreeBuilder treeBuilder = new TreeBuilder();
    public void driverMethod() {
        TreeNode root = treeBuilder.buildTree("1 2 3 4 5 6");

        for (Integer a : postOrderTraversal1(root))
            System.out.print(a + " ");
    }

    //Iterative Approach
    private List<Integer> postOrderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();    //stack2 is for getting reverse order of the collected element by stack1.
        st1.push(root);

        while (!st1.isEmpty()) {
            TreeNode curr = st1.pop();      //Collect the element in Order: root, right, left
            st2.push(curr);                 //Collect the element in Order: left, right, root  <-(which is postorder traversal)

            if(curr.left != null) st1.push(curr.left);
            if(curr.right != null) st1.push(curr.right);
        }

        while (!st2.isEmpty()) {
            res.add(st2.pop().val);     //Collecting the postorder traversal data.
        }
        return res;
    }

    //Recursive Approach
    List<Integer> res = new ArrayList<>();

    private List<Integer> postOrderTraversal(TreeNode root) {
        if(root == null) return res;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        res.add(root.val);

        return res;
    }
}
