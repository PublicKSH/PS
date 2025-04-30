import java.util.*;

class Solution {
    static StringTokenizer st;
    static TreeSet<Integer> ts;
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        ts = new TreeSet<>();
        
        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (command.equals("I")) {
                ts.add(num);
            } 
            else if (command.equals("D") && ts.size() != 0) {
                if (num == -1) {
                    int lower = ts.first();
                    ts.remove(lower);    
                }
                else {
                    int higher = ts.last();
                    ts.remove(higher);    
                }
            }
        }
        
        if (ts.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            int lower = ts.first();
            int higher = ts.last();
            answer[0] = higher;
            answer[1] = lower; 
        }
        
        return answer;
    }
}