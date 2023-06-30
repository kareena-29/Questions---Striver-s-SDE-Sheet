package Day_18;

import java.util.ArrayList;


public class PredecessorSuccessor {
    public static int predecessor(TreeNode root, int key){
		TreeNode predessor = null;

		while(root != null){
			if(key > root.val){
				predessor = root;
				root = root.right;
			}else{
				root = root.left;
			}
		}

		if(predessor == null) return -1;
		return predessor.val;
	}
	public static int successor(TreeNode root, int key){
		TreeNode sucessor = null;

		while(root != null){
			if(key >= root.val){
				root = root.right;
			}else{
				sucessor = root;
				root = root.left;
			}
		}
		if(sucessor == null) return -1;
		return sucessor.val;
	}
	public static ArrayList<Integer> predecessorSuccessor(TreeNode root, int key) {
		int a = predecessor(root, key);		
		int b = successor(root, key);

		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(a);		
		ans.add(b);
		return ans;
	}
}
