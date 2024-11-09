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
        // Dummy node initialization
        ListNode dummy = new ListNode(-1);
        ListNode s = dummy;
        
        // Merge the two lists
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                s.next = list1; 
                list1 = list1.next;
            } else {
                s.next = list2;
                list2 = list2.next;
            }
            s = s.next;
        }
        
        // Attach the remaining part
        if(list1 != null) {
            s.next = list1;
        } else {
            s.next = list2;
        }
        
        return dummy.next;
    }
}
