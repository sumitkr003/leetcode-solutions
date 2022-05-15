// https://leetcode.com/problems/count-vowels-permutation

class Solution {
    public int countVowelPermutation(int n) {
        if(n == 1) return 5;
        ArrayList<ArrayList<Integer>> rules = new ArrayList<>();
        constructRules(rules);
        
        long dp[][] = new long[n][5];
        long mod = (long)(1e9 + 7);
        for(int i=0;i<5;i++) dp[0][i] = 1;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<5;j++){
                long sum = 0;
                for(int val: rules.get(j)){
                    sum += dp[i-1][val];
                    sum = sum % mod;
                }
                dp[i][j] = sum;
            }
        }
        
        long ans = 0;
        for(long val: dp[n-1]) ans += val;
        return (int)(ans % mod);
    }
    
    public void constructRules(ArrayList<ArrayList<Integer>> arr){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        arr.add(temp);
        
        temp = new ArrayList<>();
        temp.add(0);
        temp.add(2);
        arr.add(temp);
        
        temp = new ArrayList<>();
        temp.add(0);
        temp.add(1);
        temp.add(3);
        temp.add(4);
        arr.add(temp);  
        
        temp = new ArrayList<>();
        temp.add(2);
        temp.add(4);
        arr.add(temp);      
        
        temp = new ArrayList<>();
        temp.add(0);
        arr.add(temp);
    }
}