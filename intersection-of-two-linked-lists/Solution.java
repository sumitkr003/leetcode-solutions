// https://leetcode.com/problems/intersection-of-two-linked-lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0, sizeB = 0;
        ListNode curr = headA;
        while(curr != null){
            sizeA ++;
            curr = curr.next;
        }
        
        curr = headB;
        while(curr != null){
            sizeB ++;
            curr = curr.next;
        }
        
        ListNode newCurr = null;
        if(sizeA > sizeB){
            curr = headA;
            newCurr = headB;
        }else{
            curr = headB;
            newCurr = headA;
        }
        
        while(sizeA - sizeB != 0 && curr != null){
            curr = curr.next;
            if(sizeA == sizeB) break;
            else if(sizeA > sizeB) sizeA --;
            else sizeB--;
        }
        
        // System.out.println(curr.val + " " + newCurr.val);
        while(curr != null && newCurr != null){
            if(curr == newCurr) return curr;
            curr = curr.next;
            newCurr = newCurr.next;
        }
        
        return curr;
    }
}