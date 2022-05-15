// https://leetcode.com/problems/sum-root-to-leaf-numbers

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
    public int ans = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        solve(root, 0);
        return ans;
    }
    
    public void solve(TreeNode node, int val){
        if(node.left == null && node.right == null){
            ans += (val * 10) + node.val;
            return;
        }
        
        if(node.left != null){
            solve(node.left, val * 10 + node.val);
        }
        
        if(node.right != null){
            solve(node.right , val * 10 + node.val);
        }
    }
}