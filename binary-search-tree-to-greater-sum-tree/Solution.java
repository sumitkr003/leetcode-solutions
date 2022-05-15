// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree

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
    public TreeNode bstToGst(TreeNode root) {
        solve(root, 0);
        return root;
    }
    
    public int solve(TreeNode parent, int sum){
        if(parent == null){
            return sum;
        }
        
        int right_sum = solve(parent.right, sum);
        parent.val += right_sum;
        int left_sum = solve(parent.left, parent.val);
        
        
        if(left_sum == 0){
            return parent.val;
        }
        
        return left_sum;
    }
}