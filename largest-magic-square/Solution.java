// https://leetcode.com/problems/largest-magic-square

class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 || n == 1) return 1;

        int ans = 1;
        int rowSum[][] = new int[m][n];
        int colSum[][] = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0){
                    rowSum[i][j] = grid[0][0];
                    colSum[i][j] = grid[0][0];
                }else if(j == 0){
                    rowSum[i][j] = grid[i][j];
                    colSum[i][j] = colSum[i-1][j] + grid[i][j];
                }else if(i == 0){
                    colSum[i][j] = grid[i][j];
                    rowSum[i][j] = rowSum[i][j - 1] + grid[i][j];
                }else{
                    rowSum[i][j] = rowSum[i][j - 1] + grid[i][j];
                    colSum[i][j] = colSum[i-1][j] + grid[i][j];
                }
            }
        }   
        
        int k = 2;
        while(k <= m && k <= n){
            for(int i=0;i+k<=m;i++){
                for(int j=0;j+k<=n;j++){
                    int sumOfRow = j == 0 ? rowSum[i][j + k - 1] : rowSum[i][j + k - 1] - rowSum[i][j-1];
                    if(isRowSumEqual(rowSum, i, j, k) && isColSumEqual(colSum, i, j, k, sumOfRow) && isDiagonalSumEqual(grid, i, j, k, sumOfRow)){
                        ans = k;
                        break;
                    }
                }
                
                if(ans == k) break;
            }
            k++;
        }
        
        return ans;
    }
    
    private boolean isRowSumEqual(int rowSum[][], int i, int j, int k){
        int sum = j == 0 ? rowSum[i][j + k - 1] : rowSum[i][j + k - 1] - rowSum[i][j-1];
        for(int r=0;r<k;r++){
            boolean bool = true;
            if(j == 0 && rowSum[i + r][j + k - 1] != sum) bool = false;
            else if(j != 0 && rowSum[i + r][j + k - 1] - rowSum[i + r][j-1] != sum) bool = false;
            
            if(!bool) return false;
        }
        return true;
    }
    
    private boolean isColSumEqual(int colSum[][], int i, int j, int k, int sum){
        for(int c=0;c<k;c++){
            boolean bool = true;
            if(i == 0 && colSum[i + k - 1][j+c] != sum) bool =  false;
            else if(i != 0 && colSum[i + k - 1][j+c] - colSum[i-1][j + c] != sum) bool = false;
            
            if(!bool) return false;
            
        }
        return true;
    }
    
    private boolean isDiagonalSumEqual(int grid[][], int i, int j, int gridSize, int rowSum){
        int sum = 0;
        int count = 0;
        while(count < gridSize && i + count < grid.length && j + count < grid[0].length){
            sum += grid[i + count][j + count];
            count ++;
        }
        
        if(sum != rowSum) return false;
        count = 0;
        while(count < gridSize && i + count < grid.length && j + gridSize - count - 1 >= 0){
            sum -= grid[i + count][j + gridSize - count - 1];
            count ++;
        }
        
        return sum == 0;
    }
    
    
    
    
    
    
    
    
}