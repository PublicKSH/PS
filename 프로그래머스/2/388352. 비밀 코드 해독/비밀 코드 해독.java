import java.util.*;

// 완탐 (N(10~15)개중 5개를 뽑아서)
class Solution {
    static int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        int r = 5;
        int[] pick = new int[r];
        comb(1,0,5,n,pick,q, ans);
        return answer;
    }
    
    // nCr
    public void comb(int start, int depth, int r, int n, int[] pick, int[][] q, int[] ans) {
        if (depth == r) {
            answer += check(pick, q, ans);
            return;
        }
        
        for (int i=start; i<=n; i++) {
            pick[depth] = i;
            comb(i+1, depth+1, r, n,pick,q, ans);
        }
    }
    
    public int check(int[] pick, int[][] q, int[] ans) {
        for (int i=0; i<ans.length; i++) {
            Set<Integer> setP = new HashSet<>();
            for (int num : pick) {
                setP.add(num);
            }

            Set<Integer> setQ = new HashSet<>();
            for (int num : q[i]) {
                setQ.add(num);
            }

            setP.retainAll(setQ);

            if (setP.size() != ans[i]) {
                return 0;
            }
        }
        return 1;
    }
}