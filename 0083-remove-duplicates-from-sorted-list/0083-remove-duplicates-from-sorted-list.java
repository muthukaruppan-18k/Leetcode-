
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start with the head node
        ListNode current = head;
        
        // Traverse the list until the end
        while (current != null && current.next != null) {
            // If the next node's value is the same as current, skip it
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // Otherwise, move to the next node
                current = current.next;
            }
        }
        
        return head;
    }
}
