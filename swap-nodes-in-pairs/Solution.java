// https://leetcode.com/problems/swap-nodes-in-pairs

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
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = null, prev = null, curr = head;
        
        while(curr != null && curr.next != null){
            ListNode next = curr.next;
            ListNode nextToNext = next.next;
            curr.next = nextToNext;
            next.next = curr;
            
            if(newHead == null){
                newHead = next;
            }else{
                prev.next = next;    
            }
            
            prev = curr;
            curr = nextToNext;
        }
        
        return newHead == null ? head : newHead;
    }
}