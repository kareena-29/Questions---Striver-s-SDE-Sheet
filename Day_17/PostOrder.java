package Day_17;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class PostOrder {
    static List<Integer> postOrder(TreeNode root, List<Integer> ans){
        if(root == null){
            return ans;
        }

        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.val);
    
        return ans;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // return postOrder(root,ans);
        if(root == null)
            return ans;

// using 2 - stacks
//         Stack<TreeNode> st1 = new Stack<>();
//         Stack<TreeNode> st2 = new Stack<>();

//         st1.push(root);
//         while(!st1.isEmpty()){
//             root = st1.pop();
//             st2.push(root);
//             if(root.left != null) st1.push(root.left);
//             if(root.right != null) st1.push(root.right);
//         }

//         while(!st2.isEmpty()){
//             ans.add(st2.pop().val);
//         }
//         return ans;

// using 1 - stack2
        Stack<TreeNode> st1 = new Stack<>();
        while(root != null || !st1.isEmpty()){
            if(root != null){
                st1.push(root);
                root = root.left;
            }else{
                TreeNode temp = st1.peek().right;
                if(temp == null){
                    temp = st1.peek();
                    st1.pop();
                    ans.add(temp.val);
                    while(!st1.isEmpty() && temp == (st1.peek().right)){
                       temp = st1.peek();
                        st1.pop();
                        ans.add(temp.val); 
                    }
                }else{
                    root = temp;
                }
            }
        }
        return ans;
    }
}
