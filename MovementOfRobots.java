// https://leetcode.com/problems/movement-of-robots/
import java.util.ArrayList;
import java.util.Collections;

public class MovementOfRobots {
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        ArrayList<Long> list = new ArrayList<>();
        for(int i=0;i<n;i++){
          char ch = s.charAt(i);
          if(ch=='R'){
            list.add((long)(nums[i]+0l+d));
          }else{
            list.add((long)(nums[i]+0l-d));
          }
        }
        Collections.sort(list);

        long ans = 0, preSum = list.get(0);
        long mod = (long)1e9+7;
        for(int i=1;i<n;i++){
            long val = list.get(i);
            ans = (ans + (i * val)%mod - preSum + mod)%mod;
            preSum = (preSum + val)%mod;
        }
        return (int)ans;
    }
}
