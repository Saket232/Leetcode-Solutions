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
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode odd = head;                  // Odd indexed node pointer
        ListNode even = head.next;            // Even indexed node pointer
        ListNode evenHead = even;             // Save the start of the even list

        while (even != null && even.next != null) {
            odd.next = even.next;             // Link odd node to the next odd node
            odd = odd.next;                   // Move odd pointer
            
            even.next = odd.next;             // Link even node to the next even node
            even = even.next;                 // Move even pointer
        }

        odd.next = evenHead;              // Connect end of odd list to start of even list
        return head;
    }
}
