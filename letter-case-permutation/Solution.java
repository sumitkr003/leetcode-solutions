// https://leetcode.com/problems/letter-case-permutation

class Solution {
    public List<String> letterCasePermutation(String str) {
        return solve(str, 0);
    }
    
    public List<String> solve(String str, int index){
        if(index >= str.length()){
            List<String> returnValue = new ArrayList<String>();
            returnValue.add("");
            return returnValue;
        }
        
        List<String> ans = new ArrayList<String>();
        List<String> returnedValue = solve(str, index + 1);
        char ch = str.charAt(index);
        ans = addToList(ch, returnedValue);
        
        if(ch >= 'a' && ch <= 'z'){
            ch = Character.toUpperCase(ch);
            ans.addAll(addToList(ch, returnedValue));
        }else if(ch >= 'A' && ch <= 'Z'){
            ch = Character.toLowerCase(ch);
            ans.addAll(addToList(ch, returnedValue));
        }
         
        return ans;
    }
    
    public List<String> addToList(char ch, List<String> returnedValue){
        List<String> ans = new ArrayList<String>();
        for(String s: returnedValue){
            ans.add(ch + s);
        }
        return ans;
    }
}