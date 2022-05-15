// https://leetcode.com/problems/minimum-number-of-people-to-teach

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i=0;i<languages.length;i++){
            map.put(i+1, new HashSet<>());
            for(int l : languages[i]){
                map.get(i+1).add(l);
            }
        }
        
        boolean canCommunicate[] = new boolean[friendships.length];
        for(int i=0;i<canCommunicate.length;i++){
            int u = friendships[i][0];
            int v = friendships[i][1];
            for(int l: map.get(u)){
                if(map.get(v).contains(l)){
                    canCommunicate[i] = true;
                    break;
                }
            }
        }
        
        int count = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            HashSet<Integer> teach = new HashSet<>();
            for(int j=0;j<canCommunicate.length;j++){
                if(canCommunicate[j]) continue;
                if(!map.get(friendships[j][0]).contains(i)) teach.add(friendships[j][0]);
                if(!map.get(friendships[j][1]).contains(i)) teach.add(friendships[j][1]);
            }
            count = Math.min(count, teach.size());
        }
        return count;
    }
}