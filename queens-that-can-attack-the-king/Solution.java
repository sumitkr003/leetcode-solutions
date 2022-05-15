// https://leetcode.com/problems/queens-that-can-attack-the-king

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        int r = king[0], c = king[1];
        int chess[][] = new int[8][8];
        
        for(int i=0;i<queens.length;i++){
            chess[queens[i][0]][queens[i][1]] = 1;
        }
        
        //left
        int i = r, j = c;
        while(j >= 0){
            if(chess[i][j] == 1){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
            j--;
        }
        
        //right
        j = c;
        while(j < 8){
            if(chess[i][j] == 1){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
            j++;
        }
        
        // up
        i = r;
        j = c;
        
        while(i >= 0){
            if(chess[i][j] == 1){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
            i--;
        }
        
        // down
        i = r;
        while(i < 8){
            if(chess[i][j] == 1){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
            i++;
        }
        
        
        // up - left;
        i = r;
        j = c;
        while(i > -1 && j > -1){
           if(chess[i][j] == 1){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
            i--;
            j--;
        }
        
        //up - right
        i = r;
        j = c;
        while(i > -1 && j < 8){
           if(chess[i][j] == 1){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
            i--;
            j++;
        }
        
        //down - left
        i = r;
        j = c;
        while(i < 8 && j > -1){
           if(chess[i][j] == 1){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
            i++;
            j--;
        }
        
        //down - right
        i = r;
        j = c;
        while(i < 8 && j < 8){
           if(chess[i][j] == 1){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
            i++;
            j++;
        }
        
        return ans;
    }
}