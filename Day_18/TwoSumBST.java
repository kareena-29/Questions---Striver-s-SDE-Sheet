package Day_18;

import java.util.*;
class BSTIterator{
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }
    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public int next(){
        TreeNode temp = stack.pop();
        if(reverse == false) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }

    private void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            if(reverse == true){
                node = node.right;
            }else{
                node = node.left;
            }
        }
    }

}
public class TwoSumBST {

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();
        while(i < j){
            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
