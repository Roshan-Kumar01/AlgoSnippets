//https://leetcode.com/problems/subarrays-with-k-different-integers/
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithLessThenEqualToK(nums, k) - subarraysWithLessThenEqualToK(nums, k - 1);
    }
    public int subarraysWithLessThenEqualToK(int[] nums, int k){
        int i = 0, j = 0, n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int ans = 0;
        while(j < n){
          int feq = map.getOrDefault(nums[j], 0) + 1;
          map.put(nums[j], feq);

          while(i <= j && map.size() > k){
            feq = map.get(nums[i]) - 1;
            if(feq == 0)map.remove(nums[i]);
            else map.put(nums[i], feq);
            i++;
          }
          ans += (j - i + 1);
          j++;
        }
        return ans;
    }
}