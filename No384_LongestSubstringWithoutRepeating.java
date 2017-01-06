import java.util.HashSet;

/**
 * Created by yvan on 1/5/17.
 */
public class No384_LongestSubstringWithoutRepeating  {
    public int maxsubstring(int[] nums, int s) {
        // write your code here
        int l=0;
//        int r=0;
        HashSet<Integer> set=new HashSet<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                max=Math.max(max,i-l+1);
            }else{
                for(int j=l;j<i;j++){
                    if(nums[i]==nums[j]){
                        l=j+1;
                        break;
                    }
                    if(set.contains(nums[i]))set.remove(nums[i]);
                }
            }
        }
        return max;
    }
}
