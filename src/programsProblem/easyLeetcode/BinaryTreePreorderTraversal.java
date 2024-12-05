package programsProblem.easyLeetcode;

import programsProblem.practice.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal1(TreeNode root, List<Integer> arrList) {
        if(root != null) {
            arrList.add(root.val);
            preorderTraversal1(root.left, arrList);
            preorderTraversal1(root.right, arrList);
        }
        return arrList;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arrList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            arrList.add(root.val);

            if(root.right != null) {
                stack.push(root.right);
            }
            if(root.left != null) {
                stack.push(root.left);
            }
        }
        return arrList;
    }
}
