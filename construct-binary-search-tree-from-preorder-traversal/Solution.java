// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal

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
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder, 0, preorder.length - 1);
    }
    
    // si - start index
    // ei - end index
    public TreeNode solve(int preorder[], int si, int ei){
        if(si > ei) return null;
        TreeNode node = new TreeNode(preorder[si]);
        // System.out.println("_______________");
        // System.out.println(node.val);
        if(si == ei) return node;
        
        int midIndex = si;
        for(int i=si;i<=ei;i++){
            if(preorder[i] > preorder[si]){
                midIndex = i - 1;
                break;
            }
        }
        
        // System.out.println(si + " " + midIndex + " " + ei);
        midIndex = midIndex == si && preorder[ei] < preorder[si] ? ei : midIndex;
        node.left = solve(preorder, si + 1, midIndex);
        node.right = solve(preorder, midIndex + 1, ei);
        // if(node.val == 10) System.out.println(node.left + " " + node.right);
        return node;
    }
}