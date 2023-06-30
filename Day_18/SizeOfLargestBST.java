package Day_18;

class NodeValue{
	int maxNode = 0, minNode = 0, maxSize = 0;
	NodeValue(int minNode, int maxNode, int maxSize){
		this.minNode = minNode;
		this.maxNode = maxNode;
		this.maxSize = maxSize;
	}
}
public class SizeOfLargestBST {
    public static NodeValue largestBSTSubtreeHelper(TreeNode root){
		// an empty tree is a bst of size 0
		if(root == null){
			return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		// get values from left and right subtree of current tree
		NodeValue left = largestBSTSubtreeHelper(root.left);
		NodeValue right = largestBSTSubtreeHelper(root.right);

		// Current node is greater than max in left AND Smaller than min in right
		if(left.maxNode < root.val && root.val < right.minNode){
			// it is a BST
			return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode), left.maxSize + right.maxSize + 1);
		}
		// otherwise return [-inf, inf] so that parent can't be a valid bst
		return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
	}
	public static int largestBST(TreeNode root) {
		return largestBSTSubtreeHelper(root).maxSize;
	}
}
