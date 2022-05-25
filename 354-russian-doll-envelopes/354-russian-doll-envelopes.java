class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int dp[] = new int[n];
        int len = 0;
        for(int env[]: envelopes){
            int index = Arrays.binarySearch(dp, 0, len, env[1]);
            if(index < 0) index = -(index + 1);
            dp[index] = env[1];
            if(index == len) len ++;
        }
        return len;
    }
}