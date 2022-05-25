class Solution {
    public int[] threeEqualParts(int[] arr) {
        int numOnes = 0,n=arr.length;
        for(int val: arr) numOnes += val;
        if(numOnes % 3 != 0) return new int[]{-1, -1};
        if(numOnes == 0) return new int[]{0, n-1};
        int target = numOnes/3;
        int i=-1,j=-1,k=-1,count=0;
        for(int m=0;m<n;m++){
            count += arr[m];
            if(count == 1 && i == -1) i=m;
            else if(count == target + 1 && j == -1) j=m;
            else if(count == 2*target + 1 && k == -1) k=m;
        }
        int len = arr.length - k;
        if(i==-1 || j==-1 || k==-1) return new int[]{-1,-1};
        if(check(arr, len, i, k) && check(arr, len, j, k)){
            return new int[]{i+len-1, j+len};
        }else{
            return new int[]{-1,-1};
        }
    }
    
    public boolean check(int arr[], int len, int i, int j){
        for(int m=0;m<len;m++){
            if(arr[i+m] != arr[j+m]) return false;
        }
        return true;
    }
}