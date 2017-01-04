/**
 * Created by yvan on 1/3/17.
 */
import java.util.*;
public class No558_SlidingWindowMatrix {
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        int n=nums.length;

        ArrayList<Integer> ans=new ArrayList<>();
        if(n==0)return ans;
        if(k==0)return ans;
        PriorityQueue<Integer> minheap=new PriorityQueue<>(k);
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(k,Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            if (minheap.isEmpty() || nums[i] < minheap.peek()) {
                maxheap.offer(nums[i]);
            } else {
                minheap.offer(nums[i]);
            }
            if(i>=k){
                if(maxheap.peek()>=nums[i-k])
                    maxheap.remove(nums[i-k]);
                else
                    minheap.remove(nums[i-k]);
            }
            while(maxheap.size()>minheap.size()+1){
                minheap.add(maxheap.poll());
            }
            while(minheap.size()>maxheap.size()){
                maxheap.add(minheap.poll());
            }
            if(i>=k-1)ans.add(maxheap.peek());
        }
        return ans;
    }
}
