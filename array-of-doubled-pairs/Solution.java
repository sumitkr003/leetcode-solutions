// https://leetcode.com/problems/array-of-doubled-pairs

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val: arr){
            if(map.containsKey(val)){
                map.put(val, map.get(val) + 1);
            }else{
                map.put(val, 1);
            }
        }
        
        for(int i=0;i<arr.length;i++){
            // System.out.println(arr[i] + " " + map.containsKey(arr[i]) + " " + map.containsKey(2 * arr[i]));
            if(arr[i] == 0 && map.containsKey(arr[i]) && map.get(arr[i]) % 2 == 0){
                removeFromMap(map, arr[i]);
                removeFromMap(map, arr[i]);
            }else if(arr[i] != 0 && map.containsKey(arr[i]) && map.containsKey(2 * arr[i])){
                removeFromMap(map, arr[i]);
                removeFromMap(map, 2 * arr[i]);
            }
        }
        
        return map.size() == 0;
    }
    
    public void removeFromMap(HashMap<Integer, Integer> map, int val){
        if(map.get(val) == 1) map.remove(val);
        else map.put(val, map.get(val) - 1);
    }
    
}