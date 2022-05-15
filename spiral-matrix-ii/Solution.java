// https://leetcode.com/problems/spiral-matrix-ii

class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int count = 1;
        int dir = 1;
        int r=0, c= 0;
        while(count <= n * n){
            if(dir == 1){
                if(check(arr, n, r, c)){
            // System.out.println(r + " " + c + " " + dir + " " + count);
                    
                    arr[r][c] = count;
                    c++;
                }else{
                    dir = 2;
                    c = (c == n || arr[r][c] != 0) ? c - 1 : c;
                    r++;
                }
            }
            
            if(dir == 2){
                if(check(arr, n, r, c)){
            // System.out.println(r + " " + c + " " + dir + " " + count);
                    
                    arr[r][c] = count;
                    r++;
                }else{
                    dir = 3;
                    r = (r == n || arr[r][c] != 0) ? r - 1 : r;
                    c--;
                }
            }
            
            if(dir == 3){
                if(check(arr, n, r, c)){
            // System.out.println(r + " " + c + " " + dir + " " + count);
                    
                    arr[r][c] = count;
                    c--;
                }else{
                    dir = 4;
                    c = (c < 0 || arr[r][c] != 0) ? c + 1 : c;
                    r--;
                }
            }
            
            if(dir == 4){
                if(check(arr, n, r, c)){
            // System.out.println(r + " " + c + " " + dir + " " + count);
                    
                    arr[r][c] = count;
                    r--;
                }else{
                    dir = 1;
                    r = (r < 0 || arr[r][c] != 0) ? r + 1 : r;
                    c++;
                    count --;
                }
            }
            // System.out.println(r + " " + c + " " + dir + " " + count);
            count ++;
        }
        
        return arr;
    }
    
    public boolean check(int arr[][], int n, int r, int c){
        return r >=0 && c >=0 && r < n && c < n && arr[r][c] == 0;
    }
}