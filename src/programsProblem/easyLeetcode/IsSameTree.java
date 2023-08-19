package programsProblem.easyLeetcode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(size(p) != size(q)) return false;
        int count, size;

        count = sameTree(p, q, 0);
        size = size(p);

        return count == size;
    }

    public int sameTree(TreeNode p, TreeNode q, int count) {
        if(p != null && q != null) {
            if(p.val == q.val) {
                count++;
            }
            count = sameTree(p.left, q.left, count);
            count = sameTree(p.right, q.right, count);
        }

        return count;
    }

    //Function to find size of tree
    private int size (TreeNode node)
    {
        //Base case
        if (node == null)
            return 0;

        //Calculate left subtree size
        int lsize = this.size (node.left);

        //Calculate right subtree size
        int rsize = this.size (node.right);

        //Size of tree is left subtree size + right subtree size + 1 (for root node)
        return lsize + rsize + 1;
    }
}
