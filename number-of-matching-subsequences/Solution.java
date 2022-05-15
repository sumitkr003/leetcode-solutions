// https://leetcode.com/problems/number-of-matching-subsequences

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        ArrayList<int[]> list[] = new ArrayList[26];
        
        for(int i=0;i<26;i++) list[i] = new ArrayList<>();
        
        for(int i=0;i<words.length;i++){
            String word = words[i];
            list[word.charAt(0) - 'a'].add(new int[]{i, 1});
        }
        
        for(char ch: s.toCharArray()){
            ArrayList<int[]> w = list[ch - 'a'];
            list[ch - 'a'] = new ArrayList<>();
            
            for(int val[] : w){
                String word = words[val[0]];
                int index = val[1];
                if(index != word.length()){
                    list[word.charAt(index) - 'a'].add(new int[]{val[0], index+1});
                }else{
                    count ++;
                }
            }
        }
        
        return count;
    }
    
    public boolean isSubsequence(String s, String word){
        int i=0, j=0;
        while(i < s.length() && j < word.length()){
            if(s.charAt(i) == word.charAt(j)) j++;
            i++;
        }
        return j == word.length();
    }
}