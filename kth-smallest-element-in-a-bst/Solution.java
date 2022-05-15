// https://leetcode.com/problems/kth-smallest-element-in-a-bst

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
    public int idx = 0;
    public int ans = Integer.MIN_VALUE;
    
    public int kthSmallest(TreeNode root, int k) {
        solve(root, k);
        return ans;
    }
    
    public void solve(TreeNode node, int k){
        if(node == null){
            return;
        }
        
        solve(node.left, k);
        idx ++;
        if(idx == k){
            ans = node.val;
        }else{
            solve(node.right, k);
        }
        
    }
}