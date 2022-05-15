// https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int val: chalk) sum += (long)val;
        long K = k - sum * (int)(k / sum);
        
        // System.out.println(k);
        for(int i=0;i<chalk.length;i++){
            // System.out.println(k + " " + chalk[i]);
            if(chalk[i] > K) return i;
            K -= chalk[i];
        }
        
        return -1;
    }
}