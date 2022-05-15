// https://leetcode.com/problems/check-if-it-is-a-straight-line

class Solution {
    public boolean checkStraightLine(int[][] coords) {
        if(coords.length == 2){
            return true;
        }
        
        int x1 = coords[0][0], y1 = coords[0][1], x2 = coords[1][0], y2 = coords[1][1];
        int f1 = (x2 - x1);
        int f2 = (y1 - y2);
        int c = y1*x2 - x1*y2;
        // System.out.println(f1 + " " + f2 + " " + c);
        for(int i=2;i<coords.length;i++){
            int x = coords[i][0];
            int y = coords[i][1];
            if(y * f1 + x * f2 != c){
                return false;
            }
        }
        
        return true;
    }
}