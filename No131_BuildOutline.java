import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by yvan on 1/3/17.
 */
public class No131_BuildOutline {
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<buildings.length;i++){
            if(!set.contains(buildings[i][0])){
                set.add(buildings[i][0]);
            }
            if(!set.contains(buildings[i][1])){
                set.add(buildings[i][1]);
            }
        }
        ArrayList<Integer> list=new ArrayList<>(set);
        list.sort(Integer::compareTo);
        PriorityQueue<Integer> heap=new PriorityQueue<>();

        for(Integer line: list){
            for(int[] building: buildings){
                if(building[0]<=line && building[1]>=line){
                    heap.add(building[2]);
                }
            }
        }
    }
}
