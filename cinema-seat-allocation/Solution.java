// https://leetcode.com/problems/cinema-seat-allocation

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = 2 * n;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int seat[] : reservedSeats){
            int u = seat[0];
            int v = seat[1];
            if(!map.containsKey(u)) map.put(u, new ArrayList<>());
            map.get(u).add(v);
        }
        
        for(int val: map.keySet()){
            ArrayList<Integer> arr = map.get(val);
            boolean left = false, middle = false, right = false;
            for(int index: arr){
                if(index >= 2 && index <= 5) left = true;
                if(index >= 4 && index <= 7) middle = true;
                if(index >= 6 && index <= 9) right = true;
            }
            if(left) count --;
            if(right) count --;
            if(left && right && !middle) count ++;
            // System.out.println(left + " " + right + " " + middle);
        }
        return count;
    }
}