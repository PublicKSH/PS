import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int bridgeWeight = 0;
        int truckIdx = 0;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (int i = 0 ;i< bridge_length; i++) {
            que.offer(0);
        }
        System.out.println(que.size());
        
        while(!que.isEmpty()){
            int nowTruck = que.poll();
            bridgeWeight -= nowTruck;
            time++;
            
            // 아직 넣을 트럭이 있는 경우
            if (truckIdx < truck_weights.length) {
                // 트럭을 넣을 수 있는 경우
                if (bridgeWeight + truck_weights[truckIdx] <= weight) {
                    bridgeWeight += truck_weights[truckIdx];
                    que.offer(truck_weights[truckIdx++]);
                } else {
                    que.offer(0);    
                }
            }
            
            // System.out.println(que.toString());
        }
        return time;
    }
}