package Day_17;

import java.util.*;

public class MaxWidthBinaryTree {
    public static int getMaxWidth(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ans = Math.max(ans, size);
            // as only not null nodes;

            for (int i = 0; i < size; i++) {

                TreeNode node = q.peek();
                q.poll();

                if (node.left != null) {
                    q.offer((node.left));
                }

                if (node.right != null) {
                    q.offer((node.right));
                }
            }
        }

        return ans;
    }
}
