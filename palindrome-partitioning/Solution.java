// https://leetcode.com/problems/palindrome-partitioning

class Solution {
    public List<List<String>> partition(String s) {
        HashMap<String, List<List<String>>> map = new HashMap<>();
        List<List<String>> temp = new ArrayList<>();
        temp.add(new ArrayList<>());
        map.put("", temp);
        
        for(int i=0;i<s.length();i++){
            temp = new ArrayList<>();
            for(int j=i;j>=0;j--){
                if(isPalindrome(s, j, i)){
                    String prev = s.substring(0, j);
                    String curr = s.substring(j, i+1);
                    // System.out.println(curr);
                    for(List<String> t: map.get(prev)){
                        List<String> newTemp = new ArrayList<>(t);
                        newTemp.add(curr);
                        temp.add(newTemp);
                    }
                }
            }
            map.put(s.substring(0, i+1), temp);
        }
        
        return map.get(s);
    }
    
    public boolean isPalindrome(String s, int i, int j){
        if(i == j) return true;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}