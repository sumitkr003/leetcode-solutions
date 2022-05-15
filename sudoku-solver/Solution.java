// https://leetcode.com/problems/sudoku-solver

class Solution {
    public int board[][] = new int[9][9];
    
    public void solveSudoku(char[][] b) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = b[i][j];
                if(ch == '.'){
                    board[i][j] = -1;
                }else{
                    int d = Integer.parseInt(ch + "");
                    board[i][j] = d;
                }
            }
        }
        
        if(solve(board, 0, 0)){
            print(board);
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    b[i][j] = (char)(board[i][j] + 48);
                }
            }
        }else{
            System.out.println(-1);
        }
    }
    
    public static boolean solve(int board[][], int r, int c){
        if(c > 8){
            c = 0;
            r++;
        }
        
        if(r > 8){
            return true;
        }
        
        int val = board[r][c];     
        
        boolean bool = false;
        if(val == -1){
            for(int i=1;i<10;i++){
               if(check(board, r, c, i)){
                   board[r][c] = i;
                   if(solve(board, r, c+1)){
                       bool = true;
                       break;
                   }
                   board[r][c] = -1;
               } 
            }  
        }else{
           return solve(board, r, c+1); 
        }
        
        return bool;
    }
    
    public static boolean check(int board[][], int r, int c, int val){
        for(int i=0;i<9;i++){
            int d = board[r][i];
            if(d == val){
                return false;
            }
        }
        
        for(int i=0;i<9;i++){
            int d = board[i][c];
            if(d == val){
                return false;
            }
        }
        
        int x = (r/3) * 3;
        int y = (c/3) * 3;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int d = board[x+i][y+j];
                if(d == val){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void print(int board[][]){
        for(int val[] : board){
            for(int d: val){
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}