// https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer

class Solution {
    public int maxDiff(int num) {
        String str = num + "";
        int n = str.length();
        int a[] = new int[n];
        int b[] = new int[n];
        int j = 0;
        while(num > 0){
            a[j] = num % 10;
            b[j] = a[j];
            num /= 10;
            j++;
        }
        
        int val = -1;
        int newVal = -1;
        for(int i=n-1;i>=0;i--){
            if(i==n-1 && a[i] != 1){
                val = a[i];
                a[i] = 1;
                newVal = 1;
                break;
            }else if(a[i] != 1 && a[i] != 0){
                val = a[i];
                a[i] = 0;
                newVal = 0;
                break;
            }
        }
        
        if(val != -1){
            for(int i=0;i<n;i++){
                if(a[i] == val){
                    a[i] = newVal;
                }
            }
        }
        
        val = -1;
        newVal = -1;
        for(int i=n-1;i>=0;i--){
            if(i==n-1 && b[i] != 9){
                val = b[i];
                b[i] = 9;
                newVal = 9;
                break;
            }else if(b[i] != 9){
                val = a[i];
                b[i] = 9;
                newVal = 9;
                break;
            }
        }
        
        if(val != -1){
            for(int i=0;i<n;i++){
                if(b[i] == val){
                    b[i] = newVal;
                }
            }
        }
        
        int min = 0, max = 0;
        for(int i=n-1;i>=0;i--){
            min = min * 10 + a[i];
            max = max * 10 + b[i];
        }
        
        // System.out.println(min + " " + max);
        return Math.abs(max - min);
    }
}