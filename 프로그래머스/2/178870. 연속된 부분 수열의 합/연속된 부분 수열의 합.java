import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] dp = new int[n+1];
        int[] answer = {0,n-1};
        for (int i=1; i<=n; i++) {
          dp[i] = dp[i-1] + sequence[i-1];
        }
        
        
        for (int i=0; i<=n; i++) {
            int start = i;
            int end = n;
            int mid;
            while (start < end) {
                mid = (start + end)/2;
                if (dp[mid] - dp[i] < k) {
                    start = mid+1;
                } else {
                    end = mid;
                }        
            }
            // System.out.println("i : " + i + ",start : " + start + ",end : " + end + ",sum : " + (dp[start]-dp[i]));
            if (dp[start]-dp[i] == k) {
                // System.out.println("result : " + (i) + " ~ " + (start-1));          
                // 앞쪽부터 확인하니까 같은 경우는 생각 안해도됨
                if(answer[1] - answer[0] > (start-1-i)) {
                    answer[1] = start - 1;
                    answer[0] = i;
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        
        return answer;
    }
}