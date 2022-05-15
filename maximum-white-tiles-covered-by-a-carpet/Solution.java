// https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet

class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        int n = tiles.length;
        int sum[] = new int[n];
        int first[] = new int[n];
        for(int i=0;i<n;i++){
            first[i] = tiles[i][0];
            sum[i] = tiles[i][1] - tiles[i][0] + 1;
            if(i != 0) sum[i] += sum[i-1];
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            int last = tiles[i][0] + carpetLen - 1;
            int r = binarySearchCount(first, n, last) - 1;
            int temp = r > 0 ? sum[r-1] - (i == 0 ? 0 : sum[i-1]) : 0;
            temp += r >= 0 ? Math.min(last, tiles[r][1]) - tiles[r][0] + 1 : 0;
            // System.out.println(r);
            ans = Math.max(temp, ans);
        }
        
        return ans;
    }
    
    public int binarySearchCount(int arr[], int n, int key){
        int left = 0;
        int right = n - 1;

        int count = 0;

        while (left <= right)
        {
            int mid = (right + left) / 2;

            // Check if middle element is
            // less than or equal to key
            if (arr[mid] <= key)
            {

                // At least (mid + 1) elements are there
                // whose values are less than
                // or equal to key
                count = mid + 1;
                left = mid + 1;
            }

            // If key is smaller, ignore right half
            else
                right = mid - 1;
        }
        return count;
    }
}