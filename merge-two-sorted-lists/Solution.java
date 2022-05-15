// https://leetcode.com/problems/merge-two-sorted-lists

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        
        ListNode root = null;  
        if(l1 != null && (l2 == null || l1.val < l2.val)){
            root = new ListNode(l1.val);
            l1 = l1.next;
        }else{
            root = new ListNode(l2.val);
            l2 = l2.next;
        }
        
        ListNode curr = root;
        while(l1 != null && l2 != null){
            ListNode next = curr.next;
            if(l1.val < l2.val){
                ListNode newL1 = l1.next;
                
                curr.next = l1;
                l1.next = next;
                curr = l1;
                l1 = newL1;
            }else{
                ListNode newL2 = l2.next;
                
                curr.next = l2;
                l2.next = next;
                curr = l2;
                l2 = newL2;
            }
        }
        
        if(l1 != null){
            curr.next = l1;   
        }else if(l2 != null){
            curr.next = l2;
        }
        
        return root;
    }
}