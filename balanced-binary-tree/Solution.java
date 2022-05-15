// https://leetcode.com/problems/balanced-binary-tree

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
    public boolean bool = true;
    public boolean isBalanced(TreeNode root) {
        solve(root);
        return bool;
    }
    
    public int solve(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int left = solve(node.left);
        int right = solve(node.right);
        
        if(Math.abs(left - right) > 1){
            bool = false;
        }
        
        return Math.max(left, right) + 1;
    }
}