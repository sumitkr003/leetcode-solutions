// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to

class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        List<Integer> size = new ArrayList<>();
        List<Integer> rem = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            
            if(size.isEmpty()){
                size.add(arr[i]);
                rem.add(arr[i] - 1);
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                ans.add(temp);
            }else{
                boolean bool = false;
                for(int j=0;j<size.size();j++){
                    if(size.get(j) == arr[i] && rem.get(j) > 0){
                        bool = true;
                        rem.set(j, rem.get(j) - 1);
                        ans.get(j).add(i);
                        break;
                    }
                }
                
                if(!bool){
                    size.add(arr[i]);
                    rem.add(arr[i] - 1);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    ans.add(temp); 
                }
                
            }
        }
        
        return ans;
    }
}