// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

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
    public ListNode deleteDuplicates(ListNode head) {
        return solve(null, head);
    }
    
    public ListNode solve(ListNode prev, ListNode curr){
        if(curr == null) return curr;
        
        ListNode next = solve(curr, curr.next);
        
        if(prev != null && prev.val == curr.val) return next;
        if(curr.next != null && curr.val == curr.next.val) return next;
        
        curr.next = next;
        return curr;
    }
}