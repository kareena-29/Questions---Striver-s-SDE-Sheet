package Day_7;
class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }
public class Copy_List_With_Random_Pointer {
    
    public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> iter = head;
        LinkedListNode<Integer> front = head;

        // step-1 creation of copy nodes
        while(iter != null){
            front = iter.next;
            LinkedListNode<Integer> copy = new LinkedListNode<Integer>(iter.data);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }

        // step - 2 connecting random ptrs
        iter = head;
        while(iter != null){
            if(iter.random != null){
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // step - 3 get original and deep copies back
        iter = head;
        LinkedListNode<Integer> dummy = new LinkedListNode<Integer>(0);
        LinkedListNode<Integer> cloneCopy = dummy;
       

        while(iter != null){
            front = iter.next.next;
            dummy.next = iter.next;
            iter.next = front;
            dummy = dummy.next;
            iter = iter.next;
        }
        return cloneCopy.next;
	}
}
