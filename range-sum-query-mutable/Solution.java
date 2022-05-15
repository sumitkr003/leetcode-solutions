// https://leetcode.com/problems/range-sum-query-mutable

class NumArray {
    int st[];
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        int len = 1;
        for(len=1;len <= n;len=len*2)
            
        if(n > 0){
            st = new int[4*len];
        }else{
            st = new int[0];
        }
        create(nums, 0, n-1, 0);
    }
    
    public void create(int nums[], int l, int r,int i){
        if(l == r){
            st[i] = nums[l];
            return;
        }else if(l > r){
            return;
        }
        
        int mid = (l + r)/2;
        create(nums, l, mid, 2*i+1);
        create(nums, mid+1, r, 2*i+2);
        
        st[i] = st[2*i + 1] + st[2*i + 2];
    }
    
    public void update(int i, int val) {
        update(val, 0, n-1, 0, i);
    }
    
    public void update(int val, int l, int r, int i, int j){
        if(l == r){
            if(l == j){
                st[i] = val;
            }
            return;
        }else if(l > r){
            return;
        }
        
        int mid = (l+r)/2;
        if(l <= j && j <= mid){
            update(val, l, mid, 2*i+1, j);
        }else{
            update(val, mid+1, r, 2*i+2, j);
        }
        st[i] = st[2*i+1] + st[2*i+2];
    }
    
    public int sumRange(int i, int j) {
        return sum(i, j, 0, n-1, 0);
    }
    
    public int sum(int i, int j, int l, int r, int k){
        if(k > st.length - 1){
            return 0;
        }
        if(l == r){
            if(l == i && l == j){
                return st[k];
            }
            return 0;
        }else if(l > r){
            return 0;
        }
        
        int mid = (l+r)/2;
        if(i == l && j == r){
            return st[k];
        }
        
        int left = 0, right = 0;
        if(j <= mid){
            left = sum(i, j, l, mid, 2*k + 1);
        }else if(mid < i){
            right = sum(i, j, mid+1, r, 2*k + 2);
        }else{
            left = sum(i, mid, l, mid, 2*k+1);
            right = sum(mid+1, j, mid+1, r, 2*k+2);
        }
        
        return left + right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */