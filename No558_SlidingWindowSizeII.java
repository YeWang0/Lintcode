/**
 * Created by yvan on 1/4/17.
 */
public class No558_SlidingWindowSizeII {
    public int maxSlidingMatrix(int[][] matrix, int k) {
        // Write your code here
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] sum=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            sum[i][0]=0;
        for(int j=0;j<n;j++)
            sum[0][j]=0;

        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++){
                sum[i][j]=matrix[i-1][j-1]+sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
            }
        int max=Integer.MIN_VALUE;
        for(int i=k;i<=m;i++)
            for(int j=k;j<=n;j++)
                max=Math.max(max,sum[i][j]-sum[i-k][j]-sum[i][j-k]+sum[i-k][j-k]);
        return max;
    }
}
