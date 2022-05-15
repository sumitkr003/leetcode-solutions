// https://leetcode.com/problems/partition-labels

class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        if(n < 1){
            return ans;
        }
        
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0, end = freq[s.charAt(0) - 'a'];
        for(int i=0;i<n;i++){
            if(i == end){
                ans.add(end - start + 1);
                start = i + 1;
                end = i+1 < n ? freq[s.charAt(i+1) - 'a'] : start;
            }else{
                end = Math.max(end, freq[s.charAt(i) - 'a']);
            }
        }
        
        return ans;
    }
}