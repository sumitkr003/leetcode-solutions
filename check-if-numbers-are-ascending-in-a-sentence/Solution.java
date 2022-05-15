// https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence

class Solution {
    public boolean areNumbersAscending(String s) {
        String str[] = s.split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for(String temp: str){
            try{
                int val = Integer.parseInt(temp);
                arr.add(val);
            }catch(Exception e){
                
            }
        }
        
        for(int i=1;i<arr.size();i++){
            if(arr.get(i) <= arr.get(i-1)) return false;
        }
        
        return true;
    }
}