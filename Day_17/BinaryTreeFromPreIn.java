package Day_17;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreIn {

    private TreeNode buildBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);
        int numsLeft = index - inStart;

        root.left = buildBinaryTree(preorder, preStart+1, preStart+numsLeft,inorder, inStart, index - 1, map);
        root.right = buildBinaryTree(preorder,preStart+numsLeft+1, preEnd, inorder, index+1, inEnd, map);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        TreeNode root = buildBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }
}
