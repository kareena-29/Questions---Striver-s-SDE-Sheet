package Day_17;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class InOrder {
    static List<Integer> inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return ans;
        }

        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);

        return ans;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // return inOrder(root,ans);
        if (root == null)
            return ans;

        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }

                node = st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }
}
