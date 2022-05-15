// https://leetcode.com/problems/reverse-nodes-in-k-group

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = null;
        ListNode temp = null;
        ListNode curr = head;
        
        while(curr != null){
            int count = 1;
            ListNode last = curr;
            while(last != null && count < k){
                last = last.next;
                count ++;
            }
            
            if(last == null && temp != null){
                temp.next = curr;
            }else if(last != null){
                last = last.next;
                ListNode[] arr = reverseK(curr, k);
                
                if(temp != null){
                    temp.next = arr[0];
                }
                
                temp = arr[1];
                if(last == null){
                    temp.next = null;
                }
                
                if(ans == null){
                    ans = arr[0];
                }
            }
            
            curr = last;
        }
        
        return ans;
    }
    
    public ListNode[] reverseK(ListNode node, int k){
        ListNode prev = node;
        ListNode curr = prev.next;
        
        while(k > 1 && curr != null){
            ListNode next = null;
            if(curr != null){
                next = curr.next;
                curr.next = prev;
            }
            prev = curr;
            curr = next;
            k--;
        }
        
        return new ListNode[]{prev, node};
    }
}