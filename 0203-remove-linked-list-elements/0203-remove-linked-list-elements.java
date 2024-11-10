/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0); // Dummy node
        dummy.next = head;
        ListNode current = head; // create a temp pointer
        ListNode prev = dummy;

        while (current != null) {
            if (current.val == val) {
                prev.next = current.next; // Skip the current node
            } else {
                prev = current; // Move prev only if current is not deleted
            }
            current = current.next; // Move to the next node
        }
        
        return dummy.next; // Return head from dummy.next
    }
}
