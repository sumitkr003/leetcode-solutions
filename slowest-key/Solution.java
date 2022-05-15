// https://leetcode.com/problems/slowest-key

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int freq[] = new int[26];
        for(int i=0;i<releaseTimes.length;i++){
            int f = i == 0 ? releaseTimes[i] : releaseTimes[i] - releaseTimes[i-1];
            freq[keysPressed.charAt(i) - 'a'] = Math.max(f, freq[keysPressed.charAt(i) - 'a']);
        }
        
        char ch = 'a';
        int count = 0;
        for(int i=0;i<26;i++){
            if(count <= freq[i]){
                count = freq[i];
                ch = (char)('a' + i);
            }
        }
        return ch;
    }
}