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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);  // Dummy node to act as a placeholder
        ListNode current = dummy;
        int carry = 0;  // Initialize carry

        while (l1 != null || l2 != null) {
            // Sum the values from l1 and l2, along with the carry
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

            // Create a new node with the digit part of the sum
            current.next = new ListNode(sum % 10);
            carry = sum / 10;  // Calculate new carry

            // Move to the next nodes in each list if they exist
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If there's a carry left, add a new node with the carry value
        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;  // Return the next of dummy node, which is the result list's head
    }
}
