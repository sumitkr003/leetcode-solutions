// https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid

class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int ans[] = new int[m];
        for(int i=0;i<m;i++){
            int count = 0;
            int r = startPos[0], c = startPos[1];
            for(int j=i;j<m;j++){
                if(s.charAt(j) == 'L') c--;
                else if(s.charAt(j) == 'R') c++;
                else if(s.charAt(j) == 'U') r--;
                else r++;
                
                if(r < 0 || c < 0 || r >= n || c >= n) break;
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}