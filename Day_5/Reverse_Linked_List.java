package Day_5;

public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        // Shorter one
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    
}
