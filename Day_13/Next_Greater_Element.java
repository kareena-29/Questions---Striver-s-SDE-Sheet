package Day_13;
import java.util.Stack;

public class Next_Greater_Element {
    public static int[] nextGreater(int[] arr, int n) {	
		int[] nge = new int[arr.length];
		nge[n-1] = -1;
		Stack<Integer> st = new Stack<>();
		st.push(arr[n-1]);

		for(int i=n-2; i>=0; i--){
			while(st.isEmpty() == false && st.peek() <= arr[i]){
				st.pop();
			}
			if(i<n){
				if(!st.isEmpty()) nge[i] = st.peek();
				else nge[i] = -1;
			}

			st.push(arr[i]);
		}
		return nge;
		
	}
}
