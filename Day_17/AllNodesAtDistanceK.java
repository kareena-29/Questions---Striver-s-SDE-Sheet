package Day_17;

import java.util.*;

public class AllNodesAtDistanceK {
    static void markParents(TreeNode root, Map<TreeNode, TreeNode> parents){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null){
                parents.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null){
                parents.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        markParents(root, parents);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int cur_level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            if(cur_level == k) break;
            cur_level++;
            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                if(current.left != null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }

                if(parents.get(current) != null && visited.get(parents.get(current)) == null){
                    queue.offer(parents.get(current));
                    visited.put(parents.get(current), true);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            ans.add(current.val);
        }
        return ans;
    }
}
