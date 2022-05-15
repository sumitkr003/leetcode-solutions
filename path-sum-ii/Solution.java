// https://leetcode.com/problems/path-sum-ii

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return solve(root, 0, targetSum, new ArrayList<Integer>(), new ArrayList<>());
    }
    
    public List<List<Integer>> solve(TreeNode root, int sum, int target, List<Integer> path, List<List<Integer>> ans){
        if(root == null) return ans;
        else if(root.left == null && root.right == null){
            // System.out.println(sum + root.val);
            if(sum + root.val == target){
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return ans;
        }
        
        if(root.left != null){
            path.add(root.val);
            solve(root.left, sum + root.val, target, path, ans);
            path.remove(path.size() - 1);
        }
        
        if(root.right != null){
            path.add(root.val);
            solve(root.right, sum + root.val, target, path, ans);
            path.remove(path.size() - 1);
        }
        
        return ans;
    }
}