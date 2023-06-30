package Day_18;

import java.util.*;

public class BSTIteratorQues {
    class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushAll(TreeNode node){
        for(; node != null; stack.push(node), node = node.left);
    }
}
}
