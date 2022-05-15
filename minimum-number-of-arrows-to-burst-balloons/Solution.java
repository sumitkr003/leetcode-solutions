// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

class Solution {
    public int findMinArrowShots(int[][] points) {
        ArrayList<int[]> arr = new ArrayList<>();
        for(int val[]: points) arr.add(val);
        Collections.sort(arr, (a, b) -> a[1] - b[1]);
        
        // for(int i=0;i<arr.size();i++){
        //     int start = arr.get(i)[0];
        //     int end = arr.get(i)[1];
        //     System.out.println(start + " " + end);
        // }
        
        int count = 1;
        int min = arr.get(0)[0], max = arr.get(0)[1];
        for(int i=1;i<arr.size();i++){
            int start = arr.get(i)[0], end = arr.get(i)[1];
            // System.out.println(min + " " + max + " " + start + " " + end);
            if(doesOverlap(min, max, start, end)){
                count ++;
                min = Math.min(min, start);
                max = Math.max(max, end);
            } 
        }
        
        return count;
    }
    
    public boolean doesOverlap(int min, int max, int start, int end){
        if((min <= start && start <= max) || (min <= end && end <= max)) return false;
        if((start <= min && min <= end) || (start <= max && max <= end)) return false;
        return true;
    }
}