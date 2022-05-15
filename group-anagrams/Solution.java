// https://leetcode.com/problems/group-anagrams

class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        int indexes[] = new int[strs.length];
        Arrays.fill(indexes, -1);
        List<List<String>> list = new ArrayList<>();
        
        String newStrs[] = new String[strs.length];
        for(int i=0;i<strs.length;i++){
            char arr[] = strs[i].toCharArray();
            Arrays.sort(arr);
            newStrs[i] = new String(arr);
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            if(map.containsKey(newStrs[i])){
                list.get(map.get(newStrs[i])).add(strs[i]);
            }else{
                map.put(newStrs[i], list.size());
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                list.add(temp);
            }
        }
        
        for(List<String> temp : list){
            Collections.sort(temp);
        }
        return list;
    }
}