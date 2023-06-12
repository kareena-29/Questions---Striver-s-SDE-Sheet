package Day_7;


public class Rotate_Linked_List {
    class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if(k == 0 || head == null || head.next == null) return head;

        // compute length
        int len = 1;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }

        // go till that node
        temp.next = head;
        k = len - (k%len);
        while(k-- > 0){
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}
