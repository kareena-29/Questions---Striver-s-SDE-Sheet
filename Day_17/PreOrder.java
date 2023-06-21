package Day_17;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class PreOrder {
    static List<Integer> preOrder(TreeNode root, List<Integer> ans){
        if(root == null){
            return ans;
        }

        ans.add(root.val);
        preOrder(root.left, ans);
        preOrder(root.right, ans);

        return ans;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // return preOrder(root,ans);
        if(root == null){
            return ans;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            root = st.pop();
            ans.add(root.val);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return ans;
    }
}
