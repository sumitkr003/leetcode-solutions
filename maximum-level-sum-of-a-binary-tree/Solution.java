// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree

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
    HashMap<Integer, Integer> map = new HashMap<>();
    public int maxLevelSum(TreeNode root) {
        solve(root, 1);
        int val = Integer.MIN_VALUE;
        int level = 0;
        for(int key: map.keySet()){
            if(map.get(key) > val || (map.get(key) == val && key <                  level)){
               level = key;
                val = map.get(key);
            }
        }
        return level;
    }
    
    public void solve(TreeNode root, int l){
        if(root == null){
            return;
        }
        
        if(map.containsKey(l)){
            map.put(l, map.get(l) + root.val);
        }else{
            map.put(l, root.val);
        }
        
        solve(root.left, l + 1);
        solve(root.right, l + 1);
    }
}