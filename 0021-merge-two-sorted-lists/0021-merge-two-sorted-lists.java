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
        if(list1 == null && list2 == null) {
            return list1;
        }
        
        if(list1 != null && list2 == null) {
            return list1;
        }
        
        if(list1 == null && list2 != null) {
            return list2;
        }
        
        ListNode s = new ListNode();
        ListNode newHead = null; 
        
        if(list1!= null && list2 != null) {
            if(list1.val <= list2.val) {
                s = list1; 
                list1 = s.next;
            } else {
                s = list2;
                list2 = s.next;
            }
        }
        
        newHead = s; 
        while(list1 != null && list2!= null) {
            if(list1.val <= list2.val) {
                s.next = list1;
                s = list1;
                list1 = s.next;
            } else {
                s.next = list2;
                s = list2;
                list2 = s.next; 
            }
            
        }
        
        if(list1 == null) {
            s.next = list2;
        }
        
        if(list2 == null) {
            s.next = list1;
        }
        
        return newHead;
    }
}