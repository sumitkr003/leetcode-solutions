// https://leetcode.com/problems/find-the-town-judge

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length == 0){
            return 1;
        }
        int MAX = (int)(1e4+1);
        int freq[] = new int[MAX];
        for(int i=0;i<trust.length;i++){
            freq[trust[i][1]] ++;
        }
        int ans = 0;
        for(int i=1;i<MAX;i++){
            if(freq[i] > freq[ans]){
                ans = i;
            }
        }
        for(int i=1;i<MAX;i++){
            if(freq[i] == freq[ans] && ans != i){
                return -1;
            }
        }
        for(int i=0;i<trust.length;i++){
            if(ans == trust[i][0]){
                return -1;
            }
        }
        return ans == 0 ? -1 : ans;
    }
}