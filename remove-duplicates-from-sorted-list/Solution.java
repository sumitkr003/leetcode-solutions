// https://leetcode.com/problems/remove-duplicates-from-sorted-list

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
        ListNode prev = null, curr = head;
        while(curr != null){
            if(prev != null && prev.val != curr.val){
                prev.next = curr;
            }
            // if(prev != null) System.out.println(prev.val + " " + curr.val);
            if(prev == null || prev.val != curr.val) prev = curr;
            curr = curr.next;
        }
        if(prev != null) prev.next = curr;
        return head;
    }
}