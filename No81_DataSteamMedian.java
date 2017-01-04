import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yvan on 1/3/17.
 */
public class No81_DataSteamMedian {
    Comparator p=new Comparator<Integer>() {
        @Override
        public int compare(Integer n1,Integer n2) {
            return n2-n1;
        }
    };
    PriorityQueue<Integer> minheap=new PriorityQueue<>();
    PriorityQueue<Integer> maxheap=new PriorityQueue<>(p);
    int count=0;
    public int[] medianII(int[] nums) {
        // write your code here
        for(int i=0;i<nums.length;i++){
            addElement(nums[i]);
            if(i%2==0)nums[i]=minheap.peek();
            else nums[i]=maxheap.peek();
        }
        return nums;
    }
    public void addElement(int a){
        minheap.add(a);
        if(count%2==0){
            if(!maxheap.isEmpty()&&minheap.peek()<maxheap.peek()){
                int x=minheap.poll();
                int y=maxheap.poll();
                minheap.add(y);
                maxheap.add(x);
            }
        }
        else{
            maxheap.add(minheap.poll());
        }
        count++;
    }
}
