// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
        }
        
        return solve(arr, 0, arr.size() - 1);
        
    }
    
    public TreeNode solve(ArrayList<Integer> arr, int l, int r){
        if(l > r){
            return null;
        }
        
        int mid = (l + r + 1)/2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = solve(arr, l, mid - 1);
        node.right = solve(arr, mid + 1, r);
        
        return node;
    }
}