// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return add(nums, 0, n-1);
    }
    
    public TreeNode add(int nums[], int i, int j){
        if(i > j){
            return null;
        }else if(i == j){
            return new TreeNode(nums[i]);
        }
        
        int mid = (i + j + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = add(nums, i, mid - 1);
        node.right = add(nums, mid + 1, j);
        
        return node;
    }
}