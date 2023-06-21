package Day_13;
import java.util.* ;

public class Sort_Stack {
    	static void sortedInsert(Stack<Integer> stack, int num){
		if(stack.isEmpty() || ((!stack.isEmpty() && stack.peek() < num))){
			stack.push(num);
			return;
		}
		int n = stack.pop();

		sortedInsert(stack,num);

		stack.push(n);
	}

	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()){
			return;
		}

		int num = stack.pop();

		sortStack(stack);

		sortedInsert(stack,num);
	}
}
