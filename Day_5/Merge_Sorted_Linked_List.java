package Day_5;

public class Merge_Sorted_Linked_List {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // In-place => o(1) space
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        // System.out.println(l1.val);
        ListNode res = l1;

        while (l1 != null && l2 != null) {
            ListNode temp = null;
            while (l1 != null && l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;
            // System.out.println(l1);
            // swap
            ListNode temp2 = l1;
            l1 = l2;
            l2 = temp2;

        }
        return res;
    }
}
