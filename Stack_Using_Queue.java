import java.util.ArrayDeque;
import java.util.Deque;

public class Stack_Using_Queue {
    public class Stack {

        private Deque<Integer> queue1;

        public Stack() {
            queue1 = new ArrayDeque<Integer>();
            // queue2 = new ArrayDeque<Integer>();
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            return queue1.size();
        }

        public boolean isEmpty() {
            if (queue1.isEmpty()) {
                return true;
            }
            return false;
        }

        public void push(int element) {
            queue1.push(element);
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            return queue1.poll();
            // if(isEmpty()){
            //     return -1;
            // }
            // while(!queue1.isEmpty()){
            //     queue2.add(queue1.remove());
            // }

            // int removed = queue2.remove();
            // while(!queue2.isEmpty()){
            //     queue1.add(queue2.remove());
            // }
            // return removed;
        }

        public int top() {
            if (isEmpty()) {
                return -1;
            }
            // while(!queue1.isEmpty()){
            //     queue2.add(queue1.remove());
            // }

            // int peeked = queue2.peek();
            // while(!queue2.isEmpty()){
            //     queue1.add(queue2.remove());
            // }
            // return peeked;

            return queue1.getFirst();
        }

    }
}
