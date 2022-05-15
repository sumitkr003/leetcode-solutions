// https://leetcode.com/problems/unique-binary-search-trees-ii

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
    public List<TreeNode> generateTrees(int n) {
        return generateBST(1, n);
    }
    
    public List<TreeNode> generateBST(int lo, int hi){
        List<TreeNode> ans = new ArrayList<>();
        if(lo >= hi){
            ans.add(lo == hi ? new TreeNode(lo) : null);
            return ans;
        }
        
        for(int i=lo;i<=hi;i++){
            List<TreeNode> left = generateBST(lo, i-1);
            List<TreeNode> right = generateBST(i+1, hi);
            
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i, l, r);
                    ans.add(root);
                }
            }
        }
        
        return ans;
    }
}