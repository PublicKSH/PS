// startday + day = 6, 7 
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i=0; i<schedules.length; i++) {
            // 1. 주말을 제외
            boolean success = true;
            for (int day=0; day<7; day++) {
                if ((startday+day)%7 == 6 || (startday+day)%7 == 0) {
                    // System.out.println("주말임");
                    continue;
                } else {
                    if (timelogs[i][day] <= addMinuteToTime(schedules[i],10)) {
                        // System.out.println("출근성공 : " + timelogs[i][day]);
                    } else {
                        success = false;
                        // System.out.println("출근실패 : " + timelogs[i][day]);
                    }
                }
            }
            
            if (success == true) {
                answer++;
            }
        }
        
        // System.out.println(addMinuteToTime(1258,10));
        return answer;
    }
    
    public int addMinuteToTime(int time, int addMinute) {
        int hour = time/100;
        int minute = time%100 + addMinute;
        if (minute >= 60) {
            hour++;
            minute-=60;
        }
        
        return hour*100 + minute;
    }
}