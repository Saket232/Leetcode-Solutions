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
        if(head == null) {
            return head;
        }
        
        ListNode temp = head, prev = temp;

        while(temp != null && temp.val == val){
            temp = temp.next;
            head = temp;
        }
        
        while(temp != null && temp.next != null) {
            if(temp.val == val) {
                System.out.println(prev.val);
                prev.next = temp.next;
            } else {
                prev = temp;
            }
            temp = temp.next;
        }
        
        if(temp != null && temp.next == null && temp.val == val) {
            prev.next = null;
        }
        return head;
    }
}