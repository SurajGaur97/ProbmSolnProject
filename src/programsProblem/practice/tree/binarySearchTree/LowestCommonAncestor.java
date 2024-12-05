package programsProblem.practice.tree.binarySearchTree;

import programsProblem.practice.tree.utils.TreeBuilder;
import programsProblem.practice.tree.utils.TreeNode;
import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor implements DriverClass<TreeNode> {

    boolean flag = false;

    @Override
    public void driverMethod(){
        TreeNode root = TreeBuilder.buildTree("6,2,8,0,4,7,9,null,null,3,5");
//        lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
//        lowestCommonAncestorOfBst(root, new TreeNode(2), new TreeNode(8));

        List<Integer> arr = new ArrayList<>();
        getAncestors(root, new TreeNode(5), arr);   //Getting the ancestor list(testing)
        System.out.println(arr);
    }

    public void getAncestors(TreeNode root, TreeNode p, List<Integer> arr){
        if(root == null) return;

        if(root.val == p.val){
            arr.add(root.val);
            flag = true;
            return;
        }

        getAncestors(root.left, p, arr);
        if(!flag) getAncestors(root.right, p, arr);

        if(flag) arr.add(root.val);
    }

    public TreeNode lowestCommonAncestorOfBst(TreeNode root, TreeNode p, TreeNode q){
        while (root != null)
            if(root.val > p.val && root.val > q.val)
                root = root.left;
            else if(root.val < p.val && root.val < q.val)
                root = root.right;
            else break;

        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;

        if(root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
}
