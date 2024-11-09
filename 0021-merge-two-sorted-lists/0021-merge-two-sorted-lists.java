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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode s; // Pointer for the starting node of the merged list
        if (list1.val <= list2.val) {
            s = list1;
            list1 = list1.next;
        } else {
            s = list2;
            list2 = list2.next;
        }
        
        ListNode newHead = s; // Set the start of the merged list
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                s.next = list1;
                list1 = list1.next;
            } else {
                s.next = list2;
                list2 = list2.next;
            }
            s = s.next; // Move the pointer to the end of the merged list
        }
        
        // At the end of the loop, attach any remaining nodes from either list1 or list2
        if (list1 != null) {
            s.next = list1;
        } else {
            s.next = list2;
        }
        
        return newHead; // Return the head of the merged list
    }
}