// https://leetcode.com/problems/largest-time-for-given-digits

class Solution {
    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        if(arr[0] > 2) return "";
        String ans = solve(arr, new boolean[4], 2);
        System.out.println(ans);
        if(ans == ""){
            ans = solve(arr, new boolean[4], 1);
        }
        System.out.println(ans);
        if(ans == ""){
            ans = solve(arr, new boolean[4], 0);
        }
        
        return ans;
    }
    
    public String solve(int arr[], boolean isVisited[], int start){
        String ans = "";
        int temp = largestPossible(arr, isVisited, start);
        if(temp == -1) return "";
        ans += temp;
        
        temp = largestPossible(arr, isVisited, temp == 2 ? 3 : 9);
        if(temp == -1) return "";
        ans += temp;
        ans += ":";
        
        temp = largestPossible(arr, isVisited, 5);
        if(temp == -1) return "";
        ans += temp;
        
        temp = largestPossible(arr, isVisited, 9);
        if(temp == -1) return "";
        ans += temp;
        
        return ans;
    }
    
    public int largestPossible(int arr[], boolean visited[], int max){
        int largest = -1;
        for(int i=0;i<arr.length;i++){
            if(!visited[i] && arr[i] > largest && arr[i] <= max){
                largest = arr[i];
            }
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] == largest && !visited[i]){
                visited[i] = true;
                break;
            }
        }
        
        return largest;
    }
}