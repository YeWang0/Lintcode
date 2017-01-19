import java.util.Arrays;

/**
 * Created by yvan on 1/18/17.
 */
public class No404_SubarraySumII {
    public int find(int[] A,int value ){
        int len=A.length;
        if (A[len-1] < value )
            return len;

        int l = 0, r = len-1, ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (value <= A[mid]) {
                ans = mid;
                r = mid - 1;
            }  else
                l = mid + 1;
        }
        return ans;
    }
    public int subarraySumII(int[] A, int start, int end) {
        for(int i=1;i<A.length;i++){
            A[i]+=A[i-1];
        }

        Arrays.sort(A);
        int ans=0;
        for(int i=0;i<A.length;i++){
            int left=find(A,A[i]+start);
            int right=find(A,A[i]+end+1);
            System.out.println(left+":"+right);
            ans+=right-left+1;
        }
        return ans;
    }
}