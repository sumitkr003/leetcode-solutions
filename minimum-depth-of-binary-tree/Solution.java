// https://leetcode.com/problems/minimum-depth-of-binary-tree

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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(left == 0){
            return right + 1;
        }else if(right == 0){
            return left + 1;
        }
        
        return Math.min(left, right) + 1;
    }
}