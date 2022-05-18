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
    public int findSecondMinimumValue(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        dfs(root, set);
        if(set.size() > 0) set.remove(getMin(set)); 
        if(set.size() > 0) return getMin(set);
        return -1;
    }
    
    public int getMin(HashSet<Integer> set){
        int min = Integer.MAX_VALUE;
        for(int val: set) min = Math.min(val, min);
        return min;
    }
    
    public void dfs(TreeNode root, HashSet<Integer> set){
        if(root == null) return;
        
        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }
}