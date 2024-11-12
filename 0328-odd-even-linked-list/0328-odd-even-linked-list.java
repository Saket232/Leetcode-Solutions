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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        ListNode even = head;                // Start of the even indexed nodes.
        ListNode odd = head.next;            // Start of the odd indexed nodes.
        ListNode dummyHead = odd;            // Save the start of the odd nodes to connect later.

        int indexCount = 1;
        while (even.next != null && odd.next != null) {  // Check both even.next and odd.next.
            if (indexCount % 2 != 0) {
                even.next = even.next.next;
                even = even.next;
            } else {
                odd.next = odd.next.next;
                odd = odd.next;
            }
            indexCount++;
        }

        even.next = dummyHead;               // Connect end of even list to start of odd list.
        odd.next = null;
        return head;
    }
}
