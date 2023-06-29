package Day_17;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPostIn {
    private TreeNode buildBinaryTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = map.get(postorder[postEnd]);
        int numsLeft = index - inStart;

        root.left = buildBinaryTree(inorder, inStart, index - 1, postorder, postStart, postStart+numsLeft-1, map);
        root.right = buildBinaryTree(inorder ,index + 1 , inEnd, postorder, postStart+numsLeft, postEnd-1, map);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        TreeNode root = buildBinaryTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        return root;
    }
}
