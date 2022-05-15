// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validateRows(board) && validateCols(board) && validateSubBoxes(board);
    }
    
    public boolean validateRows(char board[][]){
        for(int i=0;i<board.length;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] != '.'){
                    if(set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }
    
    public boolean validateCols(char board[][]){
        for(int i=0;i<board.length;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<board[i].length;j++){
                if(board[j][i] != '.'){
                    if(set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }
        return true;
    }
    
    public boolean validateSubBoxes(char board[][]){
        for(int i=0;i<board.length;i+=3){
            for(int j=0;j<board[i].length;j+=3){
                HashSet<Character> set = new HashSet<>();
                for(int x=0;x<3;x++){
                    for(int y=0;y<3;y++){
                        if(board[i+x][j+y] != '.'){
                            if(set.contains(board[i+x][j+y])) return false;
                            set.add(board[i+x][j+y]);
                        }
                    }
                }
            }
        }
        return true;
    }
}