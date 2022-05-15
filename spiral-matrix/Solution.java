// https://leetcode.com/problems/spiral-matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int ri = 0, ci = 0, re = matrix.length - 1, ce = matrix[0].length - 1;
        while(ri <= re && ci <= ce){
            for(int i=ci;i<=ce;i++) ans.add(matrix[ri][i]);
            ri++;
            
            for(int i=ri;i<=re;i++) ans.add(matrix[i][ce]);
            ce--;
            
            if(ri <= re) for(int i=ce;i>=ci;i--) ans.add(matrix[re][i]);
            re--;

            if(ci <= ce) for(int i=re;i>=ri;i--) ans.add(matrix[i][ci]);
            ci++;
        }
        return ans;
    }
}