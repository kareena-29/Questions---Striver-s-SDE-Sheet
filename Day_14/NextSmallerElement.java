package Day_14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerElement {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> nums, int n){
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // st.push(nums.get(n-1));
       for(int i=n-1; i>=0 ;i--){
           while(!st.isEmpty() && st.peek() >= nums.get(i)){
               st.pop();
           }

           if(!st.isEmpty()) ans.add(st.peek());
           else ans.add(-1); 

           st.push(nums.get(i));
       }
       Collections.reverse(ans);
        return ans;
    }
}
