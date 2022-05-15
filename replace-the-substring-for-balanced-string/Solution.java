// https://leetcode.com/problems/replace-the-substring-for-balanced-string

class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int freq[] = new int[4];
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == 'Q'){
                freq[0] ++;
            }else if(ch == 'W'){
                freq[1] ++;
            }else if(ch == 'E'){
                freq[2] ++;
            }else{
                freq[3] ++;
            }
        }
        
        boolean flag = true;
        for(int i=0;i<4;i++){
            if(freq[i] != n/4)
                flag = false;
        }
        if(flag)
            return 0;
        
        int extra[] = new int[4];
        for(int i=0;i<4;i++){
            extra[i] = freq[i] - n/4;
        }
        
        int j = 0;
        int len = n;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == 'Q'){
                extra[0] --;
            }else if(ch == 'W'){
                extra[1] --;
            }else if(ch == 'E'){
                extra[2] --;
            }else{
                extra[3] --;
            }
            
            if(check(extra)){
                len = Math.min(len, i-j+1);
                while(j <= i){
                    ch = s.charAt(j);
                    if(ch == 'Q'){
                        extra[0] ++;
                    }else if(ch == 'W'){
                        extra[1] ++;
                    }else if(ch == 'E'){
                        extra[2] ++;
                    }else{
                        extra[3] ++;
                    }
                    
                    // System.out.println(i + " " + j);
                    j++;
                    if(check(extra)){
                        len = Math.min(len, i-j+1);
                    }else{
                        // for(int v: extra){
                        //     System.out.print(v + " ");
                        // }
                        // System.out.println();
                        break;
                    }
                }
            }
        }
        
        return len;
    }
    
    public boolean check(int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i] > 0)
                return false;
        }
        return true;
    }
}