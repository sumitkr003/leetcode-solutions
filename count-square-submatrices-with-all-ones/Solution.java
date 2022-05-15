// https://leetcode.com/problems/count-square-submatrices-with-all-ones

class Solution {
    public int countSquares(int[][] matrix) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1){
                    count++;
                    // System.out.println(i + " " + j + " " + 1);
                    for(int k=2;k<=Math.min(m,n);k++){
                        if(check(matrix, i, j, k)){
                            count++;
                            // System.out.println(i + " " + j + " " + k);
                        }else{
                            break;
                        }
                    }
                }
            }    
        }
        
        return count;
    }
    
    public boolean check(int mat[][], int r, int c, int a){
        int m = mat.length;
        int n = mat[0].length;
        
        if(r + a > m || c + a > n){
            return false;
        }
        
        for(int i=r;i<r+a;i++){
            for(int j=c;j<c+a;j++){
                if(mat[i][j] == 0){
                    return false;
                }
            }
        }
        
        return true;
    }
}