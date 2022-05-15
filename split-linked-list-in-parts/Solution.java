// https://leetcode.com/problems/split-linked-list-in-parts

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(k == 1) return new ListNode[]{head};
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        
        curr = head;
        ListNode prev = null;
        ListNode[] ans = new ListNode[k];
        for(int i=0;i<k;i++){
            ans[i] = curr;
            int j=0;
            while(j < size/k && curr != null){
                j++;
                prev = curr;
                curr = curr.next;
            }
            
            if(size%k - i > 0 && curr != null){
                prev = curr;
                curr = curr.next;
            }
            
            if(prev != null) prev.next = null;
        }
        
        return ans;
    }
}