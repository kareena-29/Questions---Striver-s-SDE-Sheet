package Day_17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
 }
public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // 1 - for sorting vertically
        // 2 - for sorting level wise
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            // if map contains or not the vertical - x-> coordinate
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            // if map contains or not the level - y-> coordinate
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }

            if(node.right != null){
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size() - 1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}
