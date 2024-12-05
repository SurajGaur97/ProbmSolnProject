package programsProblem.practice.tree.utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBuilder {

    /**
     * Example: TreeNode root = TreeBuilder().buildTree("4,5,2,N,N,3,1,6,7");
     * Example: TreeNode root = TreeBuilder().buildTree("4,5,2,null,null,3,1,6,7");
     *
     * @param str input
     * @return
     */
    public static TreeNode buildTree(String str){

        if(str.length() == 0 || str.charAt(0) == 'N' || Character.toString(str.charAt(0)).equals("null"))
            return null;

        String[] chr = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(chr[0]));

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        int i = 1;
        while (!que.isEmpty() && i < chr.length){
            TreeNode currNode = que.poll();

            String currChar = chr[i];
            if(!currChar.equals("null")){
                currNode.left = new TreeNode(Integer.parseInt(currChar));
                que.add(currNode.left);
            }

            i++;
            if(i >= chr.length) break;

            currChar = chr[i];
            if(!currChar.equals("null")){
                currNode.right = new TreeNode(Integer.parseInt(currChar));
                que.add(currNode.right);
            }

            i++;
        }

        return root;
    }
}
