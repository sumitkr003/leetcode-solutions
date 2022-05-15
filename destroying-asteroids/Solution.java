// https://leetcode.com/problems/destroying-asteroids

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentMass = (long)(mass);
        for(int val: asteroids){
            if(currentMass < (long)(val)) return false;
            currentMass += (long)(val);
        }
        return true;
    }
}