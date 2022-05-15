// https://leetcode.com/problems/integer-replacement

class Solution {
    public int integerReplacement(int n) {
        return solve(n, new HashMap<Integer, Integer>());
    }
    
    public int solve(int n, HashMap<Integer, Integer> map){
        if(n == 1) return 0;
        if(n == Integer.MAX_VALUE) return 32;
        if(map.containsKey(n)) return map.get(n);
        
        int ans = 0;
        if(n % 2 == 0){
            ans = 1 + solve(n/2, map);
        }else{
            ans = 1 + solve(n-1, map);
            ans = Math.min(ans, 1 + solve(n+1, map));
        }
        // System.out.println(n + " " + ans);
        map.put(n, ans);
        return ans;
    }
}