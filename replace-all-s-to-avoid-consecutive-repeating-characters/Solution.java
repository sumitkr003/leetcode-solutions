// https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters

class Solution {
    public String modifyString(String s) {
        char arr[] = s.toCharArray();
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            boolean a = false, b = false;
            
            if(arr[i] == '?'){
                if(i == 0){
                    a = arr.length == 1 || arr[i+1] == 'a' ? true : false;
                    arr[i] = a ? 'b' : 'a';
                }else if(i == n-1){
                    a = arr[i-1] == 'a' ? true : false;
                    arr[i] = a ? 'b' : 'a';
                }else{
                    a = arr[i-1] == 'a' || arr[i+1] == 'a' ? true : false;
                    b = arr[i-1] == 'b' || arr[i+1] == 'b' ? true : false;
                    arr[i] = a ? (b ? 'c' : 'b') : 'a';
                }
            }
        }
        
        return new String(arr);
    }
}