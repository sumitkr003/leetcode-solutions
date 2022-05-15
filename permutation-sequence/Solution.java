// https://leetcode.com/problems/permutation-sequence

class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i + 1;
            List<Integer> kth = backtrack(new ArrayList<>(), nums, new int[]{k}, new boolean[nums.length]);
            if (kth == null)
                return null;
            return kth.toString()
                      .replaceFirst("\\[", "")
                      .replaceFirst("]", "")
                      .replaceAll(", ", "");
    }

    private List<Integer> backtrack(List<Integer> permutation, int[] nums, int[] k, boolean[] used) {
        if (permutation.size() == nums.length) {
            if (--k[0] == 0)
                return permutation;
        } else if (permutation.size() < nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    continue;
                used[i] = true;
                permutation.add(nums[i]);
                List<Integer> arrangement = backtrack(permutation, nums, k, used);
                if (arrangement != null)
                    return arrangement;
                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
        return null;
    }
}