// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        ArrayList<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<folder.length;i++){
            String f = folder[i];
            boolean flag = false;
            int j = 0;
            while(j < f.length()){
                int k = j;
                for(;k<f.length();k++){
                    if(f.charAt(k) == '/'){
                        break;
                    }
                }
                
                j = k+1;
                String sub = f.substring(0, k);
                if(set.contains(sub)){
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                set.add(f);
                ans.add(f);
            }
        }
        
        return ans;
    }
}