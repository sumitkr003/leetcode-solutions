class Solution {
    public int largestVariance(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        int freq[] = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch - 'a'] ++;
            set.add(ch);
        }
        
        for(char a: set){
            for(char b: set){
                if(a == b) continue;
                
                int currA = 0, currB = 0, remainingB = freq[b - 'a'];
                for(char c: s.toCharArray()){
                    currA += c == a ? 1 : 0;
                    currB += c == b ? 1 : 0;
                    remainingB -= c == b ? 1 : 0;
                    
                    // System.out.println(c + " " + a + " " + b + " " + currA + " " + currB);
                    if(currB > 0) ans = Math.max(ans, currA - currB);
                    if(currB > currA && remainingB > 0){
                        currA = 0;
                        currB = 0;
                    }
                }
            }
            // System.out.println();
        }
        
        return ans;
    }
}