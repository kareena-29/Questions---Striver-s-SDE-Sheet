package Day_18;

public class CeilBST {
        public  static int findCeil(TreeNode node, int key) {

        int ceil = -1;
        while(node != null){
            if(node.val == key){
                ceil = node.val;
                return ceil;
            }

            if(node.val < key){
                node = node.right;
            }else{
                ceil = node.val;
                node = node.left;
            }
        }
        return ceil;

    }
}
