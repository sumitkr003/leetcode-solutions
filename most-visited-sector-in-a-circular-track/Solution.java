// https://leetcode.com/problems/most-visited-sector-in-a-circular-track

class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int freq[] = new int[n];
        for(int i=0;i<rounds.length - 1;i++){
            int curr = rounds[i];
            int next = rounds[i+1];
            if(i != 0){
                curr ++;
            }
            while(curr != next){
                if(curr > n){
                    curr = 1;
                }
                System.out.println(curr);
                freq[curr - 1] ++;
                curr ++;
                if(curr > n){
                    curr = 1;
                }
            }
            System.out.println(next);
            freq[next - 1] ++;
        }
        
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(freq[i], max);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(freq[i] == max){
                ans.add(i+1);
            }
        }
        return ans;
    }
}