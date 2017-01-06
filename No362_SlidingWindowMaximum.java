/**
 * Created by yvan on 1/3/17.
 */
import java.util.*;
public class No362_SlidingWindowMaximum {
    class ele{
        int index;
        int value;
        public ele(int index,int value){
            this.index=index;
            this.value=value;
        }
    }
    Deque<ele> dq;
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        dq=new ArrayDeque<>();
        dq.add(new ele(0,nums[0]));
        for(int i=0;i<k;i++){
            inQueue(i,nums[i]);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=k;i<nums.length;i++){

            ans.add(dq.peekFirst().value);
            inQueue(i,nums[i]);
            if(dq.getFirst().index==i-k)dq.pollFirst();

        }
        ans.add(dq.peekFirst().value);
        return ans;
    }
    public void inQueue(int index,int value){
        while(!dq.isEmpty()&&dq.getLast().value<value){
            dq.pollLast();
        }
        dq.offer(new ele(index,value));
    }
}
