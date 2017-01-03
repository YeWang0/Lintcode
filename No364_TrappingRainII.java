import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yvan on 1/3/17.
 */
public class No364_TrappingRainII {
    class grid implements Comparable<grid>{
        int x;
        int y;
        int height;
        public grid(int x,int y, int height){
            this.x=x;
            this.y=y;
            this.height=height;
        }
        public int compareTo(grid g) {
            return this.height - g.height ;
        }
    }
    public int trapRainWater(int[][] heights) {

        int m=heights.length;
        int n=heights[0].length;
        boolean[][] eval=new boolean[m][n];
        int rain=0;
        PriorityQueue<grid> pq=new PriorityQueue<>();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(i==0||j==0||i==m-1||j==n-1){
                    pq.add(new grid(i,j,heights[i][j]));
                    eval[i][j]=true;
                }
            }
        while(pq.size()>0){
            grid g=pq.poll();
            if(g.x-1>0 && !eval[g.x-1][g.y]){
                eval[g.x-1][g.y]=true;
                pq.add(new grid(g.x-1,g.y,Math.max(heights[g.x-1][g.y],g.height)));
                rain+=Math.max(heights[g.x-1][g.y],g.height)-heights[g.x-1][g.y];
            }
            if(g.x+1<m-1 && !eval[g.x+1][g.y]){
                eval[g.x+1][g.y]=true;
                pq.add(new grid(g.x+1,g.y,Math.max(heights[g.x+1][g.y],g.height)));
                rain+=Math.max(heights[g.x+1][g.y],g.height)-heights[g.x+1][g.y];
            }
            if(g.y-1>=0 && !eval[g.x][g.y-1]){
                eval[g.x][g.y-1]=true;
                pq.add(new grid(g.x,g.y-1,Math.max(heights[g.x][g.y-1],g.height)));
                rain+=Math.max(heights[g.x][g.y-1],g.height)-heights[g.x][g.y-1];
            }
            if(g.y+1<n-1 && !eval[g.x][g.y+1]){
                eval[g.x][g.y+1]=true;
                pq.add(new grid(g.x,g.y+1,Math.max(heights[g.x][g.y+1],g.height)));
                rain+=Math.max(heights[g.x][g.y+1],g.height)-heights[g.x][g.y+1];
            }
        }
        return rain;
    }
}
