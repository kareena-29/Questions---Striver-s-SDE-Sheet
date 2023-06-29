package Day_17;
public class LCAInBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // result on returning
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            // both not null means our ans
            return root;
        }
    }
}