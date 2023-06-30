package Day_18;

public class FloorBST {
    public static int floorInBST(TreeNode node, int key) {
        int floor = -1;
        while(node != null){
            if(node.val == key){
                floor = node.val;
                return floor;
            }

            if(node.val < key){
                floor = node.val;
                node = node.right;
            }else{ 
                node = node.left;
            }
        }
        return floor;
    }
}
