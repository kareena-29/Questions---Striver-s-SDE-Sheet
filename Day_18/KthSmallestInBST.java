package Day_18;

public class KthSmallestInBST {
    public static int kthSmallest(TreeNode root, int k) 
	{
		TreeNode curr = root;
        int count = 1; //as 1 indexed
        while(curr != null){
            if(curr.left == null){
               if(count == k){
                   return curr.val;
               } 
               count++;
               curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    if(count == k){
                        return curr.val;
                    } 
                    count++;
                    curr = curr.right;
                }
            }
        }
        return -1;
	}
}
