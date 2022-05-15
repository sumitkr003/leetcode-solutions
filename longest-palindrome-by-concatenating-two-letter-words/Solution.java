// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words

class Solution {
    public int longestPalindrome(String[] words) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String str: words){
            if(str.charAt(0) == str.charAt(1)) set.add(str);
            if(map.containsKey(str)) map.put(str, map.get(str) + 1);
            else map.put(str, 1);
        }
        
        int ans = 0;
        for(String str: words){
            String rev = "" + str.charAt(1) + str.charAt(0);
            if(str.charAt(0) == str.charAt(1) && map.containsKey(str) && map.get(str) >= 2){
                ans += 4;
                map.put(str, map.get(str) - 2);
            }else if(str.charAt(0) != str.charAt(1) && map.containsKey(str) && map.get(str) > 0 && map.containsKey(rev) && map.get(rev) > 0){
                ans += 4;
                map.put(str, map.get(str) - 1);
                map.put(rev, map.get(rev) - 1);
                // System.out.println(str + " " + rev + " " + map.get(str) + " " + map.get(rev));
                
            }
            
            if(map.containsKey(str) && map.get(str) == 0) map.remove(str);
            if(map.containsKey(rev) && map.get(rev) == 0) map.remove(rev);
        }
        
        for(String str: set){
            if(map.containsKey(str) && map.get(str) > 0){
                ans += 2;
                break;
            }
        }
        
        return ans;
    }
}