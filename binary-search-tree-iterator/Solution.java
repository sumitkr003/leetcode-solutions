// https://leetcode.com/problems/binary-search-tree-iterator

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    public int idx = 0;
    public ArrayList<Integer> arr = new ArrayList<>();
    
    public BSTIterator(TreeNode root) {
        solve(root);
    }
    
    public void solve(TreeNode node){
        if(node == null){
            return;
        }
        
        solve(node.left);
        arr.add(node.val);
        solve(node.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        idx++;
        return arr.get(idx-1);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return idx < arr.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */