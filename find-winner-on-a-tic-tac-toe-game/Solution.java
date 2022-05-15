// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game

class Solution {
    public String tictactoe(int[][] moves) {
        char grid[][] = new char[3][3];
        for(int i=0;i<moves.length;i++){
            int r = moves[i][0];
            int c = moves[i][1];
            
            if(i % 2 == 0){
                grid[r][c] = 'A';
            }else{
                grid[r][c] = 'B';
            }
        }
        
        // for(char ch[]: grid){
        //     for(char c: ch){
        //         System.out.print(c + " ");
        //     }
        //     System.out.println();
        // }
        
        if(check(grid, 'A')){
            return "A";
        }else if(check(grid, 'B')){
            return "B";
        }
        
        if(moves.length < 9){
            return "Pending";
        }
        
        return "Draw";
    }
    
    public boolean check(char grid[][], char ch){
        if(grid[0][0] == ch && grid[0][1] == ch && grid[0][2] == ch){
            return true;
        }
        
        if(grid[0][0] == ch && grid[1][1] == ch && grid[2][2] == ch){
            return true;
        }
        
        if(grid[0][0] == ch && grid[1][0] == ch && grid[2][0] == ch){
            return true;
        }
        
        if(grid[2][0] == ch && grid[1][1] == ch && grid[0][2] == ch){
            return true;
        }
        
        if(grid[2][0] == ch && grid[2][1] == ch && grid[2][2] == ch){
            return true;
        }
        
        if(grid[2][2] == ch && grid[1][2] == ch && grid[0][2] == ch){
            return true;
        }
        
        if(grid[1][0] == ch && grid[1][1] == ch && grid[1][2] == ch){
            return true;
        }
        
        if(grid[0][1] == ch && grid[1][1] == ch && grid[2][1] == ch){
            return true;
        }
        
        return false;
    }
}