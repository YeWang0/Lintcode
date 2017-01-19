/**
 * Created by yvan on 1/17/17.
 */
import java.util.*;
public class No135_SubarraySum {
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        ArrayList<Integer> ans=new ArrayList<>();

        for (int i=0;i<nums.length;i++) {
            sum+=nums[i];
            if(map.containsKey(sum)){
                ans.add(map.get(nums[i])+1);
                ans.add(i);
                return ans;
            }
            else{
                map.put(sum,i);
            }
        }
        return ans;
    }
}
