// https://leetcode.com/problems/search-suggestions-system

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        
        
        char ch = searchWord.charAt(0);
        List<String> temp = new ArrayList<>();
        for(int j=0;j<products.length;j++){
            if(products[j].charAt(0) == ch){
                   temp.add(products[j]);
            }
        }
            
        Collections.sort(temp);
        ans.add(temp);
        
        for(int i=1;i<searchWord.length();i++){
            ch = searchWord.charAt(i);
            temp = new ArrayList<>();
            
            for(String str: ans.get(i-1)){
                if(str.length() > i && str.charAt(i) == ch){
                    temp.add(str);
                }
            }
            
            ans.add(temp);
        }
        
        
        for(List<String> t : ans){
            while(t.size() > 3){
                t.remove(t.size() - 1);
            }
        }
        
        return ans;
    }
}