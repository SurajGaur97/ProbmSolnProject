package programsProblem.target75.tree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;
import programsProblem.utils.DriverClass;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBT implements DriverClass<TreeNode> {
    @Override
    public void driverMethod(){
        TreeNode root = TreeBuilder.buildTree("1,2,3,null,null,4,5");
        String data = "1,2,3,null,null,4,5";

        System.out.println(serialize(root));
//        printElement(deserialize(data));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root){
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();

        if(root == null) return res.toString();

        que.add(root);
        while (!que.isEmpty()){
            TreeNode curr = que.poll();

            if(curr != null){
                res.append(curr.val).append(",");
                que.add(curr.left);
                que.add(curr.right);
            } else res.append("null,");
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data){
        if(data.length() == 0 || Character.toString(data.charAt(0)).equalsIgnoreCase("n"))
            return null;

        String[] chr = data.split(",");
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
