package programsProblem.practice.tree;

import java.util.*;

public class DuplicateSubtreeInBT {
    public void driverMethod() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(2);
        node.right.right.left = new Node(4);
        node.right.right.right = new Node(5);

        System.out.println(dupSub(node));
    }

    int dupSub(Node root) {
        Set<Node> set = new HashSet<>();

        Queue<Node> que = new LinkedList<>();

        que.add(root);
        while (!que.isEmpty()) {
            Node curr = que.poll();

            if(!set.contains(curr)) {
                set.add(curr);
            } else {
                return 1;
            }

            if(curr.left != null) que.add(curr.left);
            if(curr.right != null) que.add(curr.right);
        }

        return 0;
    }

    //Custom Node.
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.data, left, right);
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;

            if(obj == null || obj.getClass() != this.getClass())
                return false;

            Node other = (Node) obj;
            return data == other.data && Objects.equals(left, other.left) && Objects.equals(right, other.right);
        }
    }
}
