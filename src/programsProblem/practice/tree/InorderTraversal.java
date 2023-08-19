package programsProblem.practice.tree;

public class InorderTraversal {
	
	public class Node {
		public int element;
		public Node left;
		public Node right;
		
		public Node(int ele) {
			this.element = ele;
		}
	}
	
	public Node root;
	public void inOrderTraverse(Node root) {
		if(root == null) {
			return;
		}
		
		inOrderTraverse(root.left);
		System.out.print(root.element + " ");
		inOrderTraverse(root.right);
	}
}
