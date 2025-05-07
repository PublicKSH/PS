class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int start = (int) 1e9;
        int end = 0;
        
        for (int i=0; i<diffs.length; i++) {
            start = Math.min(start, diffs[i]);
            end = Math.max(end, diffs[i]);
        }
        
        while(start < end) {
            int level = (start + end)/2;
            
            if (getTotalSolvedTime(level, diffs, times) > limit) {
                start = level+1;
            }else {
                end = level;
            }
        }
        
        System.out.println(start + ", " + end);
        return start;
    }
    public long getTotalSolvedTime(int level, int[] diffs, int[] times) {
        long totalTime = times[0];
        for (int i=1; i<diffs.length; i++) {
            totalTime += getSolvedTime(diffs[i], times[i], times[i-1], level);
        }
        return totalTime;
    }
    
    
    public long getSolvedTime(long diff, long timeCur, int timePrev,int level) {
        if (diff <= level) {
            return timeCur;
        } else {
            return (diff - level)*(timeCur + timePrev) + timeCur;
        }
    }
}
// 이분 탐색?
