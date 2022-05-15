// https://leetcode.com/problems/count-words-obtained-after-adding-a-letter

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<Integer> set = new HashSet<>();
        for(String str: startWords){
            int num = 0;
            for(char ch: str.toCharArray()){
                num += Math.pow(2, ch - 'a');
            }
            // System.out.println(Integer.toBinaryString(num));
            set.add(num);
        }
        
        int count = 0;
        for(String str: targetWords){
            int num = 0;
            for(char ch: str.toCharArray()){
                num += (int)Math.pow(2, ch - 'a');
            }
            
            for(char ch: str.toCharArray()){
                int temp = num ^ (int)Math.pow(2, ch - 'a');
                if(set.contains(temp)){
                    count ++;
                    break;
                }
            }
        }
        
        return count;
    }
}