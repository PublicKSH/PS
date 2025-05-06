class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int opStartTime = minuteToSecond(op_start);
        int opEndTime = minuteToSecond(op_end);
        int videoLenTime = minuteToSecond(video_len);
        int posTime = minuteToSecond(pos);

        // 1. 초기 오프닝 스킵
        posTime = skipOp(opStartTime, opEndTime, posTime);
        
        for (int i=0; i<commands.length; i++) {
            if (commands[i].equals("next")) {
                posTime += 10;
                if (posTime > videoLenTime) {
                    posTime = videoLenTime;
                }
            } else {
                posTime -= 10;
                if (posTime < 0) {
                    posTime = 0;
                }
            }
            
            posTime = skipOp(opStartTime, opEndTime, posTime);
        }
        return secondToMinute(posTime);
    }
    
    public int skipOp(int opStartTime, int opEndTime, int posTime) {
        if (posTime >= opStartTime && posTime <= opEndTime) {
            return opEndTime;
        }
        
        return posTime;
    }
    
    public int minuteToSecond(String time) {
        String[] st = time.split(":");
        int minute = Integer.parseInt(st[0]);
        int second = Integer.parseInt(st[1]);
        
        return minute*60 + second;
    }
    
    public String secondToMinute(int time) {
        String minute = time/60 + "";
        String second = time%60 + "";
        if (minute.length() < 2) {
            minute = "0" + minute;
        }
        if (second.length() < 2) {
            second = "0" + second;
        }
        return minute + ":" + second;
    }
}

// minute -> second 변환
