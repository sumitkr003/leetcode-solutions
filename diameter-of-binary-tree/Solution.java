// https://leetcode.com/problems/diameter-of-binary-tree

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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        return solve(root)[0] - 1;
    }
    
    public int[] solve(TreeNode root){
        if(root == null){
            int temp[] = new int[2];
            temp[0] = 0;
            temp[1] = 0;
            return temp;
        }
        
        int left[] = solve(root.left);
        int right[] = solve(root.right);
        
        int ans[] = new int[2];
        ans[0] = Math.max(left[1] + right[1] + 1, Math.max(left[0], right[0]));
        ans[1] = Math.max(left[1], right[1]) + 1;
        
        return ans;
    }
}