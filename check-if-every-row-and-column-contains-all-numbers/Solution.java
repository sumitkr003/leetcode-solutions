// https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers

class Solution {
    public boolean checkValid(int[][] matrix) {
        HashSet<Integer> set = new HashSet<>();
        int n = matrix.length;
        for(int i=0;i<n;i++){
            set = new HashSet<>();
            for(int j=0;j<n;j++){
                set.add(matrix[i][j]);
            }
            if(!check(set, n)) return false;
        }
        
        for(int i=0;i<n;i++){
            set = new HashSet<>();
            for(int j=0;j<n;j++){
                set.add(matrix[j][i]);
            }
            if(!check(set, n)) return false;
        }
        return true;
    }
    
    public boolean check(HashSet<Integer> set, int n){
        for(int i=1;i<=n;i++){
            if(!set.contains(i)) return false;
        }
        return true;
    }
}