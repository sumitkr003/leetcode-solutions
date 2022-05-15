// https://leetcode.com/problems/add-two-numbers

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
        int carry = 0;
        ListNode root = null;
        ListNode prev = null;
        
        while(l1 != null || l2 != null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            // System.out.println(val1 + " " + val2 + " " + carry);
            
            int data = val1 + val2 + carry;
            carry = data >= 10 ? 1 : 0;
            data = data >= 10 ? data - 10 : data;
            
            ListNode curr = new ListNode(data);
            if(prev != null){
                prev.next = curr;
            }else{
                root = curr;
            }
            prev = curr;
            
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        if(carry != 0){
            ListNode node = new ListNode(1);
            prev.next = node;
        }
        
        return root;
    }
}