package Day_13;
public class Stack_Using_Array {
    public class Stack {
        int[] data;
        int ptr = -1;
        int size;

        Stack(int size) {
            this.data = new int[size];
            this.size = size;
        }

        void push(int num) {
            if (isFull() == 1) {
                return;
            }
            data[++ptr] = num;
        }

        int pop() {
            if (isEmpty() == 1) {
                return -1;
            }
            int removed = data[ptr--];
            return removed;
        }

        int top() {
            if (isEmpty() == 1) {
                return -1;
            }
            int top = data[ptr];
            return top;
        }

        int isEmpty() {
            if (ptr == -1) {
                return 1;
            }
            return 0;
        }

        int isFull() {
            if (ptr == size - 1) {
                return 1;
            }
            return 0;
        }
    }
}
