package Day_17;

public class ChildrenSum {
        public static void changeTree(BinaryTreeNode < Integer > root) {
        if(root == null) return;
        int child = 0;
        if(root.left != null)
            child += root.left.data;

        if(root.right != null)
            child += root.right.data;

        if(child >= root.data) root.data = child;
        else{
            if(root.left != null) root.left.data = root.data;
            // added else if as only contains positives so serves the purpose 
            // if contains negatives apply both the conditions
            else if(root.right != null) root.right.data = root.data;
        }

        
        changeTree(root.left);
        changeTree(root.right);

        // after returning
        int tot = 0;
        if(root.left != null) tot += root.left.data;        
        if(root.right != null) tot += root.right.data;
        // not a leaf node;
        if(root.left != null || root.right != null) root.data = tot;

    }
}
