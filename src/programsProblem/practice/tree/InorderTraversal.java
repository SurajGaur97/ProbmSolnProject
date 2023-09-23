package programsProblem.practice.tree;

import programsProblem.practice.tree.utils.TreeNode;

public class InorderTraversal {
	public void inOrderTraverse(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrderTraverse(root.left);
		System.out.print(root.val + " ");
		inOrderTraverse(root.right);
	}
}
