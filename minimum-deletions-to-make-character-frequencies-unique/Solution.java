// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique

class Solution {
    public int minDeletions(String s) {
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a'] ++;
        }
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for(int val : freq){
            if(val == 0){
                continue;
            }else if(set.contains(val)){
                for(int j=1;j<=val;j++){
                    if(!set.contains(val - j)){
                        ans += j;
                        if(val != j){
                            set.add(val - j);
                        }
                        break;
                    }
                }
            }else{
                set.add(val);
            }    
        }
        
        return ans;
    }
}