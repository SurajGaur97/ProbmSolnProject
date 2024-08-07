package programsProblem.practice.tree.utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBuilder {

    /**
     * Example: TreeNode root = new TreeBuilder().buildTree("4,5,2,N,N,3,1,6,7");
     * Example: TreeNode root = new TreeBuilder().buildTree("4,5,2,null,null,3,1,6,7");
     *
     * @param str
     * @return
     */
    public static TreeNode buildTree(String str) {

        if(str.length() == 0 || str.charAt(0) == 'N' || Character.toString(str.charAt(0)).equals("null")){
            return null;
        }

        String[] ip = str.split(",");
        // Create the root of the tree
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            TreeNode currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N") && !currVal.equals("null")){

                // Create the left child for the current node
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N") && !currVal.equals("null")){

                // Create the right child for the current node
                currNode.right = new TreeNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
}
