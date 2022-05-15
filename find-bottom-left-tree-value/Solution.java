// https://leetcode.com/problems/find-bottom-left-tree-value

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
    public int findBottomLeftValue(TreeNode root) {
        return solve(root, 0)[1];
    }
    
    public int[] solve(TreeNode root, int depth){
        if(root == null){
            int arr[] = new int[2];
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
        
        int arr1[] = solve(root.left, depth + 1);
        int arr2[] = solve(root.right, depth + 1);
        
        int ans[] = new int[2];
        
        if(arr1[0] == -1 && arr2[0] == -1){
            ans[0] = depth;
            ans[1] = root.val;
            return ans;
        }
        
        if(arr1[0] >= arr2[0]){
            ans[0] = arr1[0];
            ans[1] = arr1[1];
        }else{
            ans[0] = arr2[0];
            ans[1] = arr2[1];
        }
        
        return ans;
    }
}