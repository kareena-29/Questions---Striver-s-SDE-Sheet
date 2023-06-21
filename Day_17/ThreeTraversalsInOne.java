package Day_17;
import java.util.*;
class Pair {
        BinaryTreeNode<Integer> node;
        int num;

        public Pair(BinaryTreeNode<Integer> node, int num) {
            this.node = node;
            this.num = num;
        }
    }
public class ThreeTraversalsInOne {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        Stack<Pair> st = new Stack<>();

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        st.push(new Pair(root, 1));
        while (!st.isEmpty()) {
            Pair it = st.pop();

            if (it.num == 1) {
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }

            else if (it.num == 2) {
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }

            }

            else {
                post.add(it.node.data);
            }
        }
        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;
    }
}
