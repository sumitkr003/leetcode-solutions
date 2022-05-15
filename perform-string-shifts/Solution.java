// https://leetcode.com/problems/perform-string-shifts

class Solution {
    public String stringShift(String str, int[][] shift) {
        int s = 0;
        for(int i=0;i<shift.length;i++){
            if(shift[i][0] == 0){
                s -= shift[i][1];
            }else{
                s += shift[i][1];
            }
        }
        
        if(s > 0){
            s = s % str.length();
            return str.substring(str.length() - s) + str.substring(0, str.length() - s);
        }else{
            s = -s;
            s = s % str.length();
            return str.substring(s) + str.substring(0, s);

        }
    }
}