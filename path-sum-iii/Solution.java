// https://leetcode.com/problems/path-sum-iii

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return solve(root, 0, new HashMap<>(), targetSum);
    }
    
    public int solve(TreeNode root, int sum, HashMap<Integer, Integer> map, int targetSum){
        int count = 0;
        if(root == null) return count;
        
        int temp = sum + root.val;
        if(map.containsKey(temp - targetSum)) count += map.get(temp - targetSum);
        if(temp == targetSum) count ++;
        
        if(map.containsKey(temp)) map.put(temp, map.get(temp) + 1);
        else map.put(temp, 1);
        
        count += solve(root.left, temp, map, targetSum);
        count += solve(root.right, temp, map, targetSum);
        
        map.put(temp, map.get(temp) - 1);
        
        return count;
    }
}