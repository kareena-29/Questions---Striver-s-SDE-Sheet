package Day_18;

public class RecoverBST {
    private TreeNode prev;
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        // if(prev != null && first != null && last != null) return;
        if(prev != null && (root.val < prev.val)){
            // if first violation then mark as first and middle
            if(first == null){
                first = prev;
                middle = root;
            }
            // if second violation mark as last
            else{
                last = root;
            }
        }
        // mark current as prev when moving ahead
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && last != null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        } else if (first != null && middle != null) {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}
