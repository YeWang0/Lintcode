import java.util.HashSet;

/**
 * Created by yvan on 1/19/17.
 */
public class No573_BuildPostOffice {

    public int shortestDistance(int[][] grid) {
        // Write your code here
        int m=grid.length;
        int n=grid[0].length;
        int max=m*n;
    }
    public int distance(int x,int y, int[][] grid,int max,int width){
        HashSet<Integer> set=new HashSet<>();
        set.add(x);
        int count=max;
        while(count>0){
            if(x-width>0 && set.contains(x-width) && grid[(x-width)/width][(x-width)%width]!=2){
                set.add(x-width);
            }
            if(x+width<max && set.contains(x+width) && grid[(x+width)/width][(x+width)%width]!=2){
                set.add(x+width);
            }
            if((x-1)%width!=0 && set.contains(x-1) && grid[(x-1)/width][(x-1)%width]!=2){
                set.add(x-1);
            }
        }
    }
}
