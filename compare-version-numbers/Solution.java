// https://leetcode.com/problems/compare-version-numbers

class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        // System.out.println(v1.length + " " + "0.1".split(".").length);
        for(int i=0;i<v1.length || i<v2.length;i++){
            int a = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int b = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            // System.out.println(a + " " + b);
            if(a > b){
                return 1;
            }else if(b > a){
                return -1;
            }
        }
        
        return 0;
    }
}