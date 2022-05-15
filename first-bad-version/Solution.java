// https://leetcode.com/problems/first-bad-version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l <= r){
            // System.out.println(l + " " + r);
            int mid = (int)(((long)l + (long)r)/2);
            boolean bool = isBadVersion(mid);
            if(bool){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}