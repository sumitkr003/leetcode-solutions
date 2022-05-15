// https://leetcode.com/problems/n-queens

class Solution {
    public List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        int board[][] = new int[n][n];
        solve(board, 0, 0);
        return ans;
    }
    
    public void solve(int board[][], int r, int c){
        int n = board.length;
        if(c >= n){
            c = 0;
            r++;
        }
        
        if(r >= n){
            ArrayList<String> s = new ArrayList<>();
            for(int i=0;i<n;i++){
                String str = "";
                for(int j=0;j<n;j++){
                    if(board[i][j] == 1){
                        str += "Q";
                    }else{
                        str += ".";
                    }
                }
                s.add(str);
            }
            ans.add(s);
            return;
        }
        
        for(int i=c;i<n;i++){
            if(check(board, r, i)){
                board[r][i] = 1;
                solve(board, r + 1, 0);
                board[r][i] = 0;
            }
        }
        
    }
    
    public boolean check(int board[][], int r, int c){
        for(int i=r-1;i>=0;i--){
            if(board[i][c] == 1){
                return false;
            }
        }
        
        int x = r, y = c;
        while(x >= 0 && y >=0){
            if(board[x][y] == 1){
                return false;
            }
            x--;
            y--;
        }
        
        x = r;
        y = c;
        while(x >= 0 && y < board.length){
            if(board[x][y] == 1){
                return false;
            }
            x--;
            y++;
        }
        
        return true;
    }
}