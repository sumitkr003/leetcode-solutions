// https://leetcode.com/problems/first-unique-number

class FirstUnique {
    ArrayList<Integer> arr = new ArrayList<>();
    ArrayList<Boolean> bool = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int ans = -1;
    
    public FirstUnique(int[] nums) {
        for(int val: nums){
            if(map.containsKey(val)){
                int idx = map.get(val);
                bool.set(idx, false);
            }else{
                map.put(val, arr.size());
                arr.add(val);
                bool.add(true);
            }
        }
        for(int i=0;i<bool.size();i++){
            if(bool.get(i)){
                ans = i;
                break;
            }
        }
    }
    
    public int showFirstUnique() {
        if(ans != -1){
            return arr.get(ans);
        }
        return -1;
    }
    
    public void add(int val) {
        if(map.containsKey(val)){
            int idx = map.get(val);
            bool.set(idx, false);
            if(idx == ans){
                ans = findNext();
            }
        }else{
            map.put(val, arr.size());
            arr.add(val);
            bool.add(true);
            if(ans == -1){
                ans = arr.size() - 1;
            }
        }
    }
    
    public int findNext(){
        for(int i=ans+1;i<bool.size();i++){
            if(bool.get(i)){
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */